// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: VCProto.proto at 151:1
package com.live.videochat.module.api.protocol;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class LogoutResponse extends Message<LogoutResponse, LogoutResponse.Builder> {
  public static final ProtoAdapter<LogoutResponse> ADAPTER = new ProtoAdapter_LogoutResponse();

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_STATUS = 0;

  /**
   * 状态 1：成功； -1：错误
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32",
      label = WireField.Label.REQUIRED
  )
  public final Integer status;

  public LogoutResponse(Integer status) {
    this(status, ByteString.EMPTY);
  }

  public LogoutResponse(Integer status, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.status = status;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.status = status;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof LogoutResponse)) return false;
    LogoutResponse o = (LogoutResponse) other;
    return unknownFields().equals(o.unknownFields())
        && status.equals(o.status);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + status.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(", status=").append(status);
    return builder.replace(0, 2, "LogoutResponse{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<LogoutResponse, Builder> {
    public Integer status;

    public Builder() {
    }

    /**
     * 状态 1：成功； -1：错误
     */
    public Builder status(Integer status) {
      this.status = status;
      return this;
    }

    @Override
    public LogoutResponse build() {
      if (status == null) {
        throw Internal.missingRequiredFields(status, "status");
      }
      return new LogoutResponse(status, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_LogoutResponse extends ProtoAdapter<LogoutResponse> {
    ProtoAdapter_LogoutResponse() {
      super(FieldEncoding.LENGTH_DELIMITED, LogoutResponse.class);
    }

    @Override
    public int encodedSize(LogoutResponse value) {
      return ProtoAdapter.INT32.encodedSizeWithTag(1, value.status)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, LogoutResponse value) throws IOException {
      ProtoAdapter.INT32.encodeWithTag(writer, 1, value.status);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public LogoutResponse decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.status(ProtoAdapter.INT32.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public LogoutResponse redact(LogoutResponse value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
