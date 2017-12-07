// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: VCProto.proto at 410:1
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
 * ======================================================================================
 * 9.虚拟商品交易
 * ======================================================================================
 * 请求
 */
public final class VPBDealRequest extends Message<VPBDealRequest, VPBDealRequest.Builder> {
  public static final ProtoAdapter<VPBDealRequest> ADAPTER = new ProtoAdapter_VPBDealRequest();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_ID = "";

  public static final String DEFAULT_TARGETJID = "";

  public static final Integer DEFAULT_ACTION = 0;

  public static final Integer DEFAULT_DEALCOUNTS = 0;

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
   * 验证登陆
   */
  @WireField(
      tag = 3,
      adapter = "com.live.videochat.module.api.protocol.UserInfo#ADAPTER",
      label = WireField.Label.REQUIRED
  )
  public final UserInfo userInfo;

  /**
   * 商品编号，视频聊天扣费中，客户端每次有效请求需自行创建一个随机编号；
   */
  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String id;

  /**
   * 目标jid
   */
  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String targetJid;

  /**
   * 1:视频扣费；2.购买表情包
   */
  @WireField(
      tag = 6,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer action;

  /**
   * 交易数量, 若>1 则购买多件，否则为1件
   */
  @WireField(
      tag = 7,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer dealCounts;

  public VPBDealRequest(ClientInfo clientInfo, DeviceInfo deviceInfo, UserInfo userInfo, String id, String targetJid, Integer action, Integer dealCounts) {
    this(clientInfo, deviceInfo, userInfo, id, targetJid, action, dealCounts, ByteString.EMPTY);
  }

  public VPBDealRequest(ClientInfo clientInfo, DeviceInfo deviceInfo, UserInfo userInfo, String id, String targetJid, Integer action, Integer dealCounts, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.clientInfo = clientInfo;
    this.deviceInfo = deviceInfo;
    this.userInfo = userInfo;
    this.id = id;
    this.targetJid = targetJid;
    this.action = action;
    this.dealCounts = dealCounts;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.clientInfo = clientInfo;
    builder.deviceInfo = deviceInfo;
    builder.userInfo = userInfo;
    builder.id = id;
    builder.targetJid = targetJid;
    builder.action = action;
    builder.dealCounts = dealCounts;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof VPBDealRequest)) return false;
    VPBDealRequest o = (VPBDealRequest) other;
    return unknownFields().equals(o.unknownFields())
        && clientInfo.equals(o.clientInfo)
        && deviceInfo.equals(o.deviceInfo)
        && userInfo.equals(o.userInfo)
        && id.equals(o.id)
        && targetJid.equals(o.targetJid)
        && Internal.equals(action, o.action)
        && Internal.equals(dealCounts, o.dealCounts);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + clientInfo.hashCode();
      result = result * 37 + deviceInfo.hashCode();
      result = result * 37 + userInfo.hashCode();
      result = result * 37 + id.hashCode();
      result = result * 37 + targetJid.hashCode();
      result = result * 37 + (action != null ? action.hashCode() : 0);
      result = result * 37 + (dealCounts != null ? dealCounts.hashCode() : 0);
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
    builder.append(", id=").append(id);
    builder.append(", targetJid=").append(targetJid);
    if (action != null) builder.append(", action=").append(action);
    if (dealCounts != null) builder.append(", dealCounts=").append(dealCounts);
    return builder.replace(0, 2, "VPBDealRequest{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<VPBDealRequest, Builder> {
    public ClientInfo clientInfo;

    public DeviceInfo deviceInfo;

    public UserInfo userInfo;

    public String id;

    public String targetJid;

    public Integer action;

    public Integer dealCounts;

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
     * 验证登陆
     */
    public Builder userInfo(UserInfo userInfo) {
      this.userInfo = userInfo;
      return this;
    }

    /**
     * 商品编号，视频聊天扣费中，客户端每次有效请求需自行创建一个随机编号；
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * 目标jid
     */
    public Builder targetJid(String targetJid) {
      this.targetJid = targetJid;
      return this;
    }

    /**
     * 1:视频扣费；2.购买表情包
     */
    public Builder action(Integer action) {
      this.action = action;
      return this;
    }

    /**
     * 交易数量, 若>1 则购买多件，否则为1件
     */
    public Builder dealCounts(Integer dealCounts) {
      this.dealCounts = dealCounts;
      return this;
    }

    @Override
    public VPBDealRequest build() {
      if (clientInfo == null
          || deviceInfo == null
          || userInfo == null
          || id == null
          || targetJid == null) {
        throw Internal.missingRequiredFields(clientInfo, "clientInfo",
            deviceInfo, "deviceInfo",
            userInfo, "userInfo",
            id, "id",
            targetJid, "targetJid");
      }
      return new VPBDealRequest(clientInfo, deviceInfo, userInfo, id, targetJid, action, dealCounts, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_VPBDealRequest extends ProtoAdapter<VPBDealRequest> {
    ProtoAdapter_VPBDealRequest() {
      super(FieldEncoding.LENGTH_DELIMITED, VPBDealRequest.class);
    }

    @Override
    public int encodedSize(VPBDealRequest value) {
      return ClientInfo.ADAPTER.encodedSizeWithTag(1, value.clientInfo)
          + DeviceInfo.ADAPTER.encodedSizeWithTag(2, value.deviceInfo)
          + UserInfo.ADAPTER.encodedSizeWithTag(3, value.userInfo)
          + ProtoAdapter.STRING.encodedSizeWithTag(4, value.id)
          + ProtoAdapter.STRING.encodedSizeWithTag(5, value.targetJid)
          + (value.action != null ? ProtoAdapter.INT32.encodedSizeWithTag(6, value.action) : 0)
          + (value.dealCounts != null ? ProtoAdapter.INT32.encodedSizeWithTag(7, value.dealCounts) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, VPBDealRequest value) throws IOException {
      ClientInfo.ADAPTER.encodeWithTag(writer, 1, value.clientInfo);
      DeviceInfo.ADAPTER.encodeWithTag(writer, 2, value.deviceInfo);
      UserInfo.ADAPTER.encodeWithTag(writer, 3, value.userInfo);
      ProtoAdapter.STRING.encodeWithTag(writer, 4, value.id);
      ProtoAdapter.STRING.encodeWithTag(writer, 5, value.targetJid);
      if (value.action != null) ProtoAdapter.INT32.encodeWithTag(writer, 6, value.action);
      if (value.dealCounts != null) ProtoAdapter.INT32.encodeWithTag(writer, 7, value.dealCounts);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public VPBDealRequest decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.clientInfo(ClientInfo.ADAPTER.decode(reader)); break;
          case 2: builder.deviceInfo(DeviceInfo.ADAPTER.decode(reader)); break;
          case 3: builder.userInfo(UserInfo.ADAPTER.decode(reader)); break;
          case 4: builder.id(ProtoAdapter.STRING.decode(reader)); break;
          case 5: builder.targetJid(ProtoAdapter.STRING.decode(reader)); break;
          case 6: builder.action(ProtoAdapter.INT32.decode(reader)); break;
          case 7: builder.dealCounts(ProtoAdapter.INT32.decode(reader)); break;
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
    public VPBDealRequest redact(VPBDealRequest value) {
      Builder builder = value.newBuilder();
      builder.clientInfo = ClientInfo.ADAPTER.redact(builder.clientInfo);
      builder.deviceInfo = DeviceInfo.ADAPTER.redact(builder.deviceInfo);
      builder.userInfo = UserInfo.ADAPTER.redact(builder.userInfo);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
