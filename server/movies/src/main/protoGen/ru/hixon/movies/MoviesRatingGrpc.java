package ru.hixon.movies;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: moviesrating.proto")
public final class MoviesRatingGrpc {

  private MoviesRatingGrpc() {}

  public static final String SERVICE_NAME = "MoviesRating";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetRatingMethod()} instead. 
  public static final io.grpc.MethodDescriptor<ru.hixon.movies.Moviesrating.GetRatingRequest,
      ru.hixon.movies.Moviesrating.GetRatingResponse> METHOD_GET_RATING = getGetRatingMethodHelper();

  private static volatile io.grpc.MethodDescriptor<ru.hixon.movies.Moviesrating.GetRatingRequest,
      ru.hixon.movies.Moviesrating.GetRatingResponse> getGetRatingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<ru.hixon.movies.Moviesrating.GetRatingRequest,
      ru.hixon.movies.Moviesrating.GetRatingResponse> getGetRatingMethod() {
    return getGetRatingMethodHelper();
  }

  private static io.grpc.MethodDescriptor<ru.hixon.movies.Moviesrating.GetRatingRequest,
      ru.hixon.movies.Moviesrating.GetRatingResponse> getGetRatingMethodHelper() {
    io.grpc.MethodDescriptor<ru.hixon.movies.Moviesrating.GetRatingRequest, ru.hixon.movies.Moviesrating.GetRatingResponse> getGetRatingMethod;
    if ((getGetRatingMethod = MoviesRatingGrpc.getGetRatingMethod) == null) {
      synchronized (MoviesRatingGrpc.class) {
        if ((getGetRatingMethod = MoviesRatingGrpc.getGetRatingMethod) == null) {
          MoviesRatingGrpc.getGetRatingMethod = getGetRatingMethod = 
              io.grpc.MethodDescriptor.<ru.hixon.movies.Moviesrating.GetRatingRequest, ru.hixon.movies.Moviesrating.GetRatingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MoviesRating", "GetRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.hixon.movies.Moviesrating.GetRatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.hixon.movies.Moviesrating.GetRatingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MoviesRatingMethodDescriptorSupplier("GetRating"))
                  .build();
          }
        }
     }
     return getGetRatingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MoviesRatingStub newStub(io.grpc.Channel channel) {
    return new MoviesRatingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MoviesRatingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MoviesRatingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MoviesRatingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MoviesRatingFutureStub(channel);
  }

  /**
   */
  public static abstract class MoviesRatingImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRating(ru.hixon.movies.Moviesrating.GetRatingRequest request,
        io.grpc.stub.StreamObserver<ru.hixon.movies.Moviesrating.GetRatingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRatingMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRatingMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                ru.hixon.movies.Moviesrating.GetRatingRequest,
                ru.hixon.movies.Moviesrating.GetRatingResponse>(
                  this, METHODID_GET_RATING)))
          .build();
    }
  }

  /**
   */
  public static final class MoviesRatingStub extends io.grpc.stub.AbstractStub<MoviesRatingStub> {
    private MoviesRatingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MoviesRatingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MoviesRatingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MoviesRatingStub(channel, callOptions);
    }

    /**
     */
    public void getRating(ru.hixon.movies.Moviesrating.GetRatingRequest request,
        io.grpc.stub.StreamObserver<ru.hixon.movies.Moviesrating.GetRatingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRatingMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MoviesRatingBlockingStub extends io.grpc.stub.AbstractStub<MoviesRatingBlockingStub> {
    private MoviesRatingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MoviesRatingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MoviesRatingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MoviesRatingBlockingStub(channel, callOptions);
    }

    /**
     */
    public ru.hixon.movies.Moviesrating.GetRatingResponse getRating(ru.hixon.movies.Moviesrating.GetRatingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRatingMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MoviesRatingFutureStub extends io.grpc.stub.AbstractStub<MoviesRatingFutureStub> {
    private MoviesRatingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MoviesRatingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MoviesRatingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MoviesRatingFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.hixon.movies.Moviesrating.GetRatingResponse> getRating(
        ru.hixon.movies.Moviesrating.GetRatingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRatingMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RATING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MoviesRatingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MoviesRatingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RATING:
          serviceImpl.getRating((ru.hixon.movies.Moviesrating.GetRatingRequest) request,
              (io.grpc.stub.StreamObserver<ru.hixon.movies.Moviesrating.GetRatingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MoviesRatingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MoviesRatingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.hixon.movies.Moviesrating.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MoviesRating");
    }
  }

  private static final class MoviesRatingFileDescriptorSupplier
      extends MoviesRatingBaseDescriptorSupplier {
    MoviesRatingFileDescriptorSupplier() {}
  }

  private static final class MoviesRatingMethodDescriptorSupplier
      extends MoviesRatingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MoviesRatingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MoviesRatingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MoviesRatingFileDescriptorSupplier())
              .addMethod(getGetRatingMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
