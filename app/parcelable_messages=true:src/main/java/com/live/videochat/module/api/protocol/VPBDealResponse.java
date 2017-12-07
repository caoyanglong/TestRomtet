// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: VCProto.proto at 422:1
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

/**
 * 响应
 */
public final class VPBDealResponse extends Message<VPBDealResponse, VPBDealResponse.Builder> {
  public static final ProtoAdapter<VPBDealResponse> ADAPTER = new ProtoAdapter_VPBDealResponse();

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_STATUS = 0;

  /**
   * 返回状态:1：成功;-1：错误;
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32",
      label = WireField.Label.REQUIRED
  )
  public final Integer status;

  @WireField(
      tag = 2,
      adapter = "com.live.videochat.module.api.protocol.AccountInfo#ADAPTER"
  )
  public final AccountInfo accountInfo;

  public VPBDealResponse(Integer status, AccountInfo accountInfo) {
    this(status, accountInfo, ByteString.EMPTY);
  }

  public VPBDealResponse(Integer status, AccountInfo accountInfo, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.status = status;
    this.accountInfo = accountInfo;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.status = status;
    builder.accountInfo = accountInfo;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof VPBDealResponse)) return false;
    VPBDealResponse o = (VPBDealResponse) other;
    return unknownFields().equals(o.unknownFields())
        && status.equals(o.status)
        && Internal.equals(accountInfo, o.accountInfo);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + status.hashCode();
      result = result * 37 + (accountInfo != null ? accountInfo.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(", status=").append(status);
    if (accountInfo != null) builder.append(", accountInfo=").append(accountInfo);
    return builder.replace(0, 2, "VPBDealResponse{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<VPBDealResponse, Builder> {
    public Integer status;

    public AccountInfo accountInfo;

    public Builder() {
    }

    /**
     * 返回状态:1：成功;-1：错误;
     */
    public Builder status(Integer status) {
      this.status = status;
      return this;
    }

    public Builder accountInfo(AccountInfo accountInfo) {
      this.accountInfo = accountInfo;
      return this;
    }

    @Override
    public VPBDealResponse build() {
      if (status == null) {
        throw Internal.missingRequiredFields(status, "status");
      }
      return new VPBDealResponse(status, accountInfo, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_VPBDealResponse extends ProtoAdapter<VPBDealResponse> {
    ProtoAdapter_VPBDealResponse() {
      super(FieldEncoding.LENGTH_DELIMITED, VPBDealResponse.class);
    }

    @Override
    public int encodedSize(VPBDealResponse value) {
      return ProtoAdapter.INT32.encodedSizeWithTag(1, value.status)
          + (value.accountInfo != null ? AccountInfo.ADAPTER.encodedSizeWithTag(2, value.accountInfo) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, VPBDealResponse value) throws IOException {
      ProtoAdapter.INT32.encodeWithTag(writer, 1, value.status);
      if (value.accountInfo != null) AccountInfo.ADAPTER.encodeWithTag(writer, 2, value.accountInfo);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public VPBDealResponse decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.status(ProtoAdapter.INT32.decode(reader)); break;
          case 2: builder.accountInfo(AccountInfo.ADAPTER.decode(reader)); break;
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
    public VPBDealResponse redact(VPBDealResponse value) {
      Builder builder = value.newBuilder();
      if (builder.accountInfo != null) builder.accountInfo = AccountInfo.ADAPTER.redact(builder.accountInfo);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
