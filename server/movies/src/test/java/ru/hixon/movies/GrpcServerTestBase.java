package ru.hixon.movies;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.inprocess.InProcessChannelBuilder;
import org.junit.After;
import org.junit.Before;
import org.lognet.springboot.grpc.GRpcServerRunner;
import org.lognet.springboot.grpc.autoconfigure.GRpcServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Optional;

public abstract class GrpcServerTestBase {

    @Autowired(required = false)
    @Qualifier("grpcServerRunner")
    protected GRpcServerRunner grpcServerRunner;

    @Autowired(required = false)
    @Qualifier("grpcInprocessServerRunner")
    protected GRpcServerRunner grpcInprocessServerRunner;


    protected ManagedChannel channel;
    protected ManagedChannel inProcChannel;

    @Autowired
    protected ApplicationContext context;

    @Autowired
    protected GRpcServerProperties gRpcServerProperties;

    @Before
    public final void setupChannels() {
        if(gRpcServerProperties.isEnabled()) {
            channel = onChannelBuild(ManagedChannelBuilder.forAddress("localhost",getPort() )
                    .usePlaintext(true)
            ).build();
        }
        if(StringUtils.hasText(gRpcServerProperties.getInProcessServerName())){
            inProcChannel = onChannelBuild(
                    InProcessChannelBuilder.forName(gRpcServerProperties.getInProcessServerName())
                            .usePlaintext(true)
            ).build();

        }
    }
    protected int getPort(){
        return  gRpcServerProperties.getPort();
    }

    protected ManagedChannelBuilder<?>  onChannelBuild(ManagedChannelBuilder<?> channelBuilder){
        return  channelBuilder;
    }

    protected InProcessChannelBuilder onChannelBuild(InProcessChannelBuilder channelBuilder){
        return  channelBuilder;
    }

    @After
    public final void shutdownChannels() {
        Optional.ofNullable(channel).ifPresent(ManagedChannel::shutdownNow);
        Optional.ofNullable(inProcChannel).ifPresent(ManagedChannel::shutdownNow);
    }
}
