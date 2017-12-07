// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: VCProto.proto at 368:1
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
import java.util.List;
import okio.ByteString;

/**
 * 响应
 */
public final class RankResponse extends Message<RankResponse, RankResponse.Builder> {
  public static final ProtoAdapter<RankResponse> ADAPTER = new ProtoAdapter_RankResponse();

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_STATUS = 0;

  public static final Integer DEFAULT_INDEX = 0;

  /**
   * 返回状态:1：成功;-1：错误;
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32",
      label = WireField.Label.REQUIRED
  )
  public final Integer status;

  /**
   * Top Fans排行榜
   */
  @WireField(
      tag = 2,
      adapter = "com.live.videochat.module.api.protocol.UserVCard#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<UserVCard> topFans;

  /**
   * 最近充值排行榜
   */
  @WireField(
      tag = 3,
      adapter = "com.live.videochat.module.api.protocol.UserVCard#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<UserVCard> latelyRechargedUsers;

  /**
   * 土豪榜：日榜
   */
  @WireField(
      tag = 4,
      adapter = "com.live.videochat.module.api.protocol.UserVCard#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<UserVCard> dailyTycoons;

  /**
   * 土豪榜：周榜
   */
  @WireField(
      tag = 5,
      adapter = "com.live.videochat.module.api.protocol.UserVCard#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<UserVCard> weeklyTycoons;

  /**
   * 主播魅力榜：日榜
   */
  @WireField(
      tag = 6,
      adapter = "com.live.videochat.module.api.protocol.AnchorVCard#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<AnchorVCard> dailyCharms;

  /**
   * 主播魅力榜：周榜
   */
  @WireField(
      tag = 7,
      adapter = "com.live.videochat.module.api.protocol.AnchorVCard#ADAPTER",
      label = WireField.Label.REPEATED
  )
  public final List<AnchorVCard> weeklyCharms;

  /**
   * 分页索引，默认为0
   */
  @WireField(
      tag = 8,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer index;

  public RankResponse(Integer status, List<UserVCard> topFans, List<UserVCard> latelyRechargedUsers, List<UserVCard> dailyTycoons, List<UserVCard> weeklyTycoons, List<AnchorVCard> dailyCharms, List<AnchorVCard> weeklyCharms, Integer index) {
    this(status, topFans, latelyRechargedUsers, dailyTycoons, weeklyTycoons, dailyCharms, weeklyCharms, index, ByteString.EMPTY);
  }

  public RankResponse(Integer status, List<UserVCard> topFans, List<UserVCard> latelyRechargedUsers, List<UserVCard> dailyTycoons, List<UserVCard> weeklyTycoons, List<AnchorVCard> dailyCharms, List<AnchorVCard> weeklyCharms, Integer index, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.status = status;
    this.topFans = Internal.immutableCopyOf("topFans", topFans);
    this.latelyRechargedUsers = Internal.immutableCopyOf("latelyRechargedUsers", latelyRechargedUsers);
    this.dailyTycoons = Internal.immutableCopyOf("dailyTycoons", dailyTycoons);
    this.weeklyTycoons = Internal.immutableCopyOf("weeklyTycoons", weeklyTycoons);
    this.dailyCharms = Internal.immutableCopyOf("dailyCharms", dailyCharms);
    this.weeklyCharms = Internal.immutableCopyOf("weeklyCharms", weeklyCharms);
    this.index = index;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.status = status;
    builder.topFans = Internal.copyOf("topFans", topFans);
    builder.latelyRechargedUsers = Internal.copyOf("latelyRechargedUsers", latelyRechargedUsers);
    builder.dailyTycoons = Internal.copyOf("dailyTycoons", dailyTycoons);
    builder.weeklyTycoons = Internal.copyOf("weeklyTycoons", weeklyTycoons);
    builder.dailyCharms = Internal.copyOf("dailyCharms", dailyCharms);
    builder.weeklyCharms = Internal.copyOf("weeklyCharms", weeklyCharms);
    builder.index = index;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof RankResponse)) return false;
    RankResponse o = (RankResponse) other;
    return unknownFields().equals(o.unknownFields())
        && status.equals(o.status)
        && topFans.equals(o.topFans)
        && latelyRechargedUsers.equals(o.latelyRechargedUsers)
        && dailyTycoons.equals(o.dailyTycoons)
        && weeklyTycoons.equals(o.weeklyTycoons)
        && dailyCharms.equals(o.dailyCharms)
        && weeklyCharms.equals(o.weeklyCharms)
        && Internal.equals(index, o.index);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + status.hashCode();
      result = result * 37 + topFans.hashCode();
      result = result * 37 + latelyRechargedUsers.hashCode();
      result = result * 37 + dailyTycoons.hashCode();
      result = result * 37 + weeklyTycoons.hashCode();
      result = result * 37 + dailyCharms.hashCode();
      result = result * 37 + weeklyCharms.hashCode();
      result = result * 37 + (index != null ? index.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(", status=").append(status);
    if (!topFans.isEmpty()) builder.append(", topFans=").append(topFans);
    if (!latelyRechargedUsers.isEmpty()) builder.append(", latelyRechargedUsers=").append(latelyRechargedUsers);
    if (!dailyTycoons.isEmpty()) builder.append(", dailyTycoons=").append(dailyTycoons);
    if (!weeklyTycoons.isEmpty()) builder.append(", weeklyTycoons=").append(weeklyTycoons);
    if (!dailyCharms.isEmpty()) builder.append(", dailyCharms=").append(dailyCharms);
    if (!weeklyCharms.isEmpty()) builder.append(", weeklyCharms=").append(weeklyCharms);
    if (index != null) builder.append(", index=").append(index);
    return builder.replace(0, 2, "RankResponse{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<RankResponse, Builder> {
    public Integer status;

    public List<UserVCard> topFans;

    public List<UserVCard> latelyRechargedUsers;

    public List<UserVCard> dailyTycoons;

    public List<UserVCard> weeklyTycoons;

    public List<AnchorVCard> dailyCharms;

    public List<AnchorVCard> weeklyCharms;

    public Integer index;

    public Builder() {
      topFans = Internal.newMutableList();
      latelyRechargedUsers = Internal.newMutableList();
      dailyTycoons = Internal.newMutableList();
      weeklyTycoons = Internal.newMutableList();
      dailyCharms = Internal.newMutableList();
      weeklyCharms = Internal.newMutableList();
    }

    /**
     * 返回状态:1：成功;-1：错误;
     */
    public Builder status(Integer status) {
      this.status = status;
      return this;
    }

    /**
     * Top Fans排行榜
     */
    public Builder topFans(List<UserVCard> topFans) {
      Internal.checkElementsNotNull(topFans);
      this.topFans = topFans;
      return this;
    }

    /**
     * 最近充值排行榜
     */
    public Builder latelyRechargedUsers(List<UserVCard> latelyRechargedUsers) {
      Internal.checkElementsNotNull(latelyRechargedUsers);
      this.latelyRechargedUsers = latelyRechargedUsers;
      return this;
    }

    /**
     * 土豪榜：日榜
     */
    public Builder dailyTycoons(List<UserVCard> dailyTycoons) {
      Internal.checkElementsNotNull(dailyTycoons);
      this.dailyTycoons = dailyTycoons;
      return this;
    }

    /**
     * 土豪榜：周榜
     */
    public Builder weeklyTycoons(List<UserVCard> weeklyTycoons) {
      Internal.checkElementsNotNull(weeklyTycoons);
      this.weeklyTycoons = weeklyTycoons;
      return this;
    }

    /**
     * 主播魅力榜：日榜
     */
    public Builder dailyCharms(List<AnchorVCard> dailyCharms) {
      Internal.checkElementsNotNull(dailyCharms);
      this.dailyCharms = dailyCharms;
      return this;
    }

    /**
     * 主播魅力榜：周榜
     */
    public Builder weeklyCharms(List<AnchorVCard> weeklyCharms) {
      Internal.checkElementsNotNull(weeklyCharms);
      this.weeklyCharms = weeklyCharms;
      return this;
    }

    /**
     * 分页索引，默认为0
     */
    public Builder index(Integer index) {
      this.index = index;
      return this;
    }

    @Override
    public RankResponse build() {
      if (status == null) {
        throw Internal.missingRequiredFields(status, "status");
      }
      return new RankResponse(status, topFans, latelyRechargedUsers, dailyTycoons, weeklyTycoons, dailyCharms, weeklyCharms, index, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_RankResponse extends ProtoAdapter<RankResponse> {
    ProtoAdapter_RankResponse() {
      super(FieldEncoding.LENGTH_DELIMITED, RankResponse.class);
    }

    @Override
    public int encodedSize(RankResponse value) {
      return ProtoAdapter.INT32.encodedSizeWithTag(1, value.status)
          + UserVCard.ADAPTER.asRepeated().encodedSizeWithTag(2, value.topFans)
          + UserVCard.ADAPTER.asRepeated().encodedSizeWithTag(3, value.latelyRechargedUsers)
          + UserVCard.ADAPTER.asRepeated().encodedSizeWithTag(4, value.dailyTycoons)
          + UserVCard.ADAPTER.asRepeated().encodedSizeWithTag(5, value.weeklyTycoons)
          + AnchorVCard.ADAPTER.asRepeated().encodedSizeWithTag(6, value.dailyCharms)
          + AnchorVCard.ADAPTER.asRepeated().encodedSizeWithTag(7, value.weeklyCharms)
          + (value.index != null ? ProtoAdapter.INT32.encodedSizeWithTag(8, value.index) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, RankResponse value) throws IOException {
      ProtoAdapter.INT32.encodeWithTag(writer, 1, value.status);
      UserVCard.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.topFans);
      UserVCard.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.latelyRechargedUsers);
      UserVCard.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.dailyTycoons);
      UserVCard.ADAPTER.asRepeated().encodeWithTag(writer, 5, value.weeklyTycoons);
      AnchorVCard.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.dailyCharms);
      AnchorVCard.ADAPTER.asRepeated().encodeWithTag(writer, 7, value.weeklyCharms);
      if (value.index != null) ProtoAdapter.INT32.encodeWithTag(writer, 8, value.index);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public RankResponse decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.status(ProtoAdapter.INT32.decode(reader)); break;
          case 2: builder.topFans.add(UserVCard.ADAPTER.decode(reader)); break;
          case 3: builder.latelyRechargedUsers.add(UserVCard.ADAPTER.decode(reader)); break;
          case 4: builder.dailyTycoons.add(UserVCard.ADAPTER.decode(reader)); break;
          case 5: builder.weeklyTycoons.add(UserVCard.ADAPTER.decode(reader)); break;
          case 6: builder.dailyCharms.add(AnchorVCard.ADAPTER.decode(reader)); break;
          case 7: builder.weeklyCharms.add(AnchorVCard.ADAPTER.decode(reader)); break;
          case 8: builder.index(ProtoAdapter.INT32.decode(reader)); break;
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
    public RankResponse redact(RankResponse value) {
      Builder builder = value.newBuilder();
      Internal.redactElements(builder.topFans, UserVCard.ADAPTER);
      Internal.redactElements(builder.latelyRechargedUsers, UserVCard.ADAPTER);
      Internal.redactElements(builder.dailyTycoons, UserVCard.ADAPTER);
      Internal.redactElements(builder.weeklyTycoons, UserVCard.ADAPTER);
      Internal.redactElements(builder.dailyCharms, AnchorVCard.ADAPTER);
      Internal.redactElements(builder.weeklyCharms, AnchorVCard.ADAPTER);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
