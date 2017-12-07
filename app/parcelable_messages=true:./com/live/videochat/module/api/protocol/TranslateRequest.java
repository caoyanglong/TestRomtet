// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: VCProto.proto at 341:1
package com.live.videochat.module.api.protocol;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

/**
 * ======================================================================================
 * 10.翻译
 * ======================================================================================
 * 请求
 */
public final class TranslateRequest extends Message<TranslateRequest, TranslateRequest.Builder> {
  public static final ProtoAdapter<TranslateRequest> ADAPTER = new ProtoAdapter_TranslateRequest();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_TARGETLANG = "";

  public static final String DEFAULT_SOURCETEXT = "";

  /**
   * 客户端信息
   */
  @WireField(
      tag = 1,
      adapter = "com.live.videochat.module.api.protocol.ClientInfo#ADAPTER",
      label = WireField.Label.REQUIRED
  )
  public final ClientInfo clientInfo;

  /**
   * 设备信息
   */
  @WireField(
      tag = 2,
      adapter = "com.live.videochat.module.api.protocol.DeviceInfo#ADAPTER",
      label = WireField.Label.REQUIRED
  )
  public final DeviceInfo deviceInfo;

  /**
   * 用户信息（jid, vcToken, role）
   */
  @WireField(
      tag = 3,
      adapter = "com.live.videochat.module.api.protocol.UserInfo#ADAPTER",
      label = WireField.Label.REQUIRED
  )
  public final UserInfo userInfo;

  /**
   * 目标语言
   */
  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String targetLang;

  /**
   * 需要翻译的文本
   */
  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String sourceText;

  public TranslateRequest(ClientInfo clientInfo, DeviceInfo deviceInfo, UserInfo userInfo, String targetLang, String sourceText) {
    this(clientInfo, deviceInfo, userInfo, targetLang, sourceText, ByteString.EMPTY);
  }

  public TranslateRequest(ClientInfo clientInfo, DeviceInfo deviceInfo, UserInfo userInfo, String targetLang, String sourceText, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.clientInfo = clientInfo;
    this.deviceInfo = deviceInfo;
    this.userInfo = userInfo;
    this.targetLang = targetLang;
    this.sourceText = sourceText;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.clientInfo = clientInfo;
    builder.deviceInfo = deviceInfo;
    builder.userInfo = userInfo;
    builder.targetLang = targetLang;
    builder.sourceText = sourceText;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof TranslateRequest)) return false;
    TranslateRequest o = (TranslateRequest) other;
    return unknownFields().equals(o.unknownFields())
        && clientInfo.equals(o.clientInfo)
        && deviceInfo.equals(o.deviceInfo)
        && userInfo.equals(o.userInfo)
        && targetLang.equals(o.targetLang)
        && sourceText.equals(o.sourceText);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + clientInfo.hashCode();
      result = result * 37 + deviceInfo.hashCode();
      result = result * 37 + userInfo.hashCode();
      result = result * 37 + targetLang.hashCode();
      result = result * 37 + sourceText.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(", clientInfo=").append(clientInfo);
    builder.append(", deviceInfo=").append(deviceInfo);
    builder.append(", userInfo=").append(userInfo);
    builder.append(", targetLang=").append(targetLang);
    builder.append(", sourceText=").append(sourceText);
    return builder.replace(0, 2, "TranslateRequest{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<TranslateRequest, Builder> {
    public ClientInfo clientInfo;

    public DeviceInfo deviceInfo;

    public UserInfo userInfo;

    public String targetLang;

    public String sourceText;

    public Builder() {
    }

    /**
     * 客户端信息
     */
    public Builder clientInfo(ClientInfo clientInfo) {
      this.clientInfo = clientInfo;
      return this;
    }

    /**
     * 设备信息
     */
    public Builder deviceInfo(DeviceInfo deviceInfo) {
      this.deviceInfo = deviceInfo;
      return this;
    }

    /**
     * 用户信息（jid, vcToken, role）
     */
    public Builder userInfo(UserInfo userInfo) {
      this.userInfo = userInfo;
      return this;
    }

    /**
     * 目标语言
     */
    public Builder targetLang(String targetLang) {
      this.targetLang = targetLang;
      return this;
    }

    /**
     * 需要翻译的文本
     */
    public Builder sourceText(String sourceText) {
      this.sourceText = sourceText;
      return this;
    }

    @Override
    public TranslateRequest build() {
      if (clientInfo == null
          || deviceInfo == null
          || userInfo == null
          || targetLang == null
          || sourceText == null) {
        throw Internal.missingRequiredFields(clientInfo, "clientInfo",
            deviceInfo, "deviceInfo",
            userInfo, "userInfo",
            targetLang, "targetLang",
            sourceText, "sourceText");
      }
      return new TranslateRequest(clientInfo, deviceInfo, userInfo, targetLang, sourceText, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_TranslateRequest extends ProtoAdapter<TranslateRequest> {
    ProtoAdapter_TranslateRequest() {
      super(FieldEncoding.LENGTH_DELIMITED, TranslateRequest.class);
    }

    @Override
    public int encodedSize(TranslateRequest value) {
      return ClientInfo.ADAPTER.encodedSizeWithTag(1, value.clientInfo)
          + DeviceInfo.ADAPTER.encodedSizeWithTag(2, value.deviceInfo)
          + UserInfo.ADAPTER.encodedSizeWithTag(3, value.userInfo)
          + ProtoAdapter.STRING.encodedSizeWithTag(4, value.targetLang)
          + ProtoAdapter.STRING.encodedSizeWithTag(5, value.sourceText)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, TranslateRequest value) throws IOException {
      ClientInfo.ADAPTER.encodeWithTag(writer, 1, value.clientInfo);
      DeviceInfo.ADAPTER.encodeWithTag(writer, 2, value.deviceInfo);
      UserInfo.ADAPTER.encodeWithTag(writer, 3, value.userInfo);
      ProtoAdapter.STRING.encodeWithTag(writer, 4, value.targetLang);
      ProtoAdapter.STRING.encodeWithTag(writer, 5, value.sourceText);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public TranslateRequest decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.clientInfo(ClientInfo.ADAPTER.decode(reader)); break;
          case 2: builder.deviceInfo(DeviceInfo.ADAPTER.decode(reader)); break;
          case 3: builder.userInfo(UserInfo.ADAPTER.decode(reader)); break;
          case 4: builder.targetLang(ProtoAdapter.STRING.decode(reader)); break;
          case 5: builder.sourceText(ProtoAdapter.STRING.decode(reader)); break;
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
    public TranslateRequest redact(TranslateRequest value) {
      Builder builder = value.newBuilder();
      builder.clientInfo = ClientInfo.ADAPTER.redact(builder.clientInfo);
      builder.deviceInfo = DeviceInfo.ADAPTER.redact(builder.deviceInfo);
      builder.userInfo = UserInfo.ADAPTER.redact(builder.userInfo);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
