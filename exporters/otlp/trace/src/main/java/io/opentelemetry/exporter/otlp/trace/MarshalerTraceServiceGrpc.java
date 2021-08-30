/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.exporter.otlp.trace;

import static io.grpc.MethodDescriptor.generateFullMethodName;

import io.grpc.MethodDescriptor;
import io.opentelemetry.exporter.otlp.internal.TraceRequestMarshaler;
import io.opentelemetry.exporter.otlp.internal.grpc.MarshalerInputStream;
import java.io.InputStream;

// Adapted from the protoc generated code for TraceServiceGrpc.
final class MarshalerTraceServiceGrpc {

  private static final String SERVICE_NAME = "opentelemetry.proto.collector.trace.v1.TraceService";

  private static final MethodDescriptor.Marshaller<TraceRequestMarshaler> REQUEST_MARSHALLER =
      new MethodDescriptor.Marshaller<TraceRequestMarshaler>() {
        @Override
        public InputStream stream(TraceRequestMarshaler value) {
          return new MarshalerInputStream(value);
        }

        @Override
        public TraceRequestMarshaler parse(InputStream stream) {
          throw new UnsupportedOperationException("Only for serializing");
        }
      };

  private static final MethodDescriptor.Marshaller<ExportTraceServiceResponse> RESPONSE_MARSHALER =
      new MethodDescriptor.Marshaller<ExportTraceServiceResponse>() {
        @Override
        public InputStream stream(ExportTraceServiceResponse value) {
          throw new UnsupportedOperationException("Only for parsing");
        }

        @Override
        public ExportTraceServiceResponse parse(InputStream stream) {
          return ExportTraceServiceResponse.INSTANCE;
        }
      };

  private static volatile io.grpc.MethodDescriptor<
          TraceRequestMarshaler, ExportTraceServiceResponse>
      getExportMethod;

  static TraceServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TraceServiceFutureStub>() {
          @java.lang.Override
          public TraceServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TraceServiceFutureStub(channel, callOptions);
          }
        };
    return TraceServiceFutureStub.newStub(factory, channel);
  }

  static final class TraceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MarshalerTraceServiceGrpc.TraceServiceFutureStub> {
    private TraceServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MarshalerTraceServiceGrpc.TraceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MarshalerTraceServiceGrpc.TraceServiceFutureStub(channel, callOptions);
    }

    com.google.common.util.concurrent.ListenableFuture<ExportTraceServiceResponse> export(
        TraceRequestMarshaler request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportMethod(), getCallOptions()), request);
    }
  }

  private static io.grpc.MethodDescriptor<TraceRequestMarshaler, ExportTraceServiceResponse>
      getExportMethod() {
    io.grpc.MethodDescriptor<TraceRequestMarshaler, ExportTraceServiceResponse> getExportMethod;
    if ((getExportMethod = MarshalerTraceServiceGrpc.getExportMethod) == null) {
      synchronized (MarshalerTraceServiceGrpc.class) {
        if ((getExportMethod = MarshalerTraceServiceGrpc.getExportMethod) == null) {
          MarshalerTraceServiceGrpc.getExportMethod =
              getExportMethod =
                  io.grpc.MethodDescriptor
                      .<TraceRequestMarshaler, ExportTraceServiceResponse>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Export"))
                      .setRequestMarshaller(REQUEST_MARSHALLER)
                      .setResponseMarshaller(RESPONSE_MARSHALER)
                      .build();
        }
      }
    }
    return getExportMethod;
  }

  private MarshalerTraceServiceGrpc() {}
}