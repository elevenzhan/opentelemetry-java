package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.logs.data.Severity;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class DefaultLogEmitterTest {

  private static final LogEmitter logEmitter = DefaultLogEmitter.getInstance();

  @Test
  void noopLogEmitter_doesNotThrow() {
    logEmitter.logBuilder()
        .setName("1").setBody("2").setSeverity(Severity.INFO)
        .setEpoch(1L, TimeUnit.NANOSECONDS)
        .setAttributes(Attributes.empty())
        .setContext(Context.current())
        .setEpoch(Instant.now()).setSeverityText("INFO").emit();
  }
}
