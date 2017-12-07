// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: VCProto.proto at 237:1
package com.live.videochat.module.api.protocol;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

/**
 * 贴纸/表情素材
 */
public final class Material extends Message<Material, Material.Builder> {
  public static final ProtoAdapter<Material> ADAPTER = new ProtoAdapter_Material();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_ID = "";

  public static final String DEFAULT_THUMBURL = "";

  public static final String DEFAULT_DOWNLOADURL = "";

  public static final Integer DEFAULT_CATEGORYTYPE = 0;

  public static final Integer DEFAULT_PRIORITY = 0;

  public static final String DEFAULT_NAME = "";

  public static final Integer DEFAULT_TABID = 0;

  public static final Boolean DEFAULT_ISNEW = false;

  /**
   * 素材编号
   */
  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String id;

  /**
   * 缩略图
   */
  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String thumbUrl;

  /**
   * 下载链接
   */
  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String downloadUrl;

  /**
   * 类型 0:贴纸；1：表情
   */
  @WireField(
      tag = 4,
      adapter = "com.squareup.wire.ProtoAdapter#INT32",
      label = WireField.Label.REQUIRED
  )
  public final Integer categoryType;

  /**
   * 素材优先级；0为最高优先级，在最前面显示
   */
  @WireField(
      tag = 5,
      adapter = "com.squareup.wire.ProtoAdapter#INT32",
      label = WireField.Label.REQUIRED
  )
  public final Integer priority;

  /**
   * 素材名称,表情名称
   */
  @WireField(
      tag = 6,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String name;

  /**
   * 标签编号:从1开始，每种类型下又有多个标签；相同的tabId显示在同一个tab下。
   */
  @WireField(
      tag = 7,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer tabId;

  /**
   * 是否是新素材
   */
  @WireField(
      tag = 8,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean isNew;

  public Material(String id, String thumbUrl, String downloadUrl, Integer categoryType, Integer priority, String name, Integer tabId, Boolean isNew) {
    this(id, thumbUrl, downloadUrl, categoryType, priority, name, tabId, isNew, ByteString.EMPTY);
  }

  public Material(String id, String thumbUrl, String downloadUrl, Integer categoryType, Integer priority, String name, Integer tabId, Boolean isNew, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.id = id;
    this.thumbUrl = thumbUrl;
    this.downloadUrl = downloadUrl;
    this.categoryType = categoryType;
    this.priority = priority;
    this.name = name;
    this.tabId = tabId;
    this.isNew = isNew;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.id = id;
    builder.thumbUrl = thumbUrl;
    builder.downloadUrl = downloadUrl;
    builder.categoryType = categoryType;
    builder.priority = priority;
    builder.name = name;
    builder.tabId = tabId;
    builder.isNew = isNew;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Material)) return false;
    Material o = (Material) other;
    return unknownFields().equals(o.unknownFields())
        && id.equals(o.id)
        && thumbUrl.equals(o.thumbUrl)
        && downloadUrl.equals(o.downloadUrl)
        && categoryType.equals(o.categoryType)
        && priority.equals(o.priority)
        && Internal.equals(name, o.name)
        && Internal.equals(tabId, o.tabId)
        && Internal.equals(isNew, o.isNew);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + id.hashCode();
      result = result * 37 + thumbUrl.hashCode();
      result = result * 37 + downloadUrl.hashCode();
      result = result * 37 + categoryType.hashCode();
      result = result * 37 + priority.hashCode();
      result = result * 37 + (name != null ? name.hashCode() : 0);
      result = result * 37 + (tabId != null ? tabId.hashCode() : 0);
      result = result * 37 + (isNew != null ? isNew.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(", id=").append(id);
    builder.append(", thumbUrl=").append(thumbUrl);
    builder.append(", downloadUrl=").append(downloadUrl);
    builder.append(", categoryType=").append(categoryType);
    builder.append(", priority=").append(priority);
    if (name != null) builder.append(", name=").append(name);
    if (tabId != null) builder.append(", tabId=").append(tabId);
    if (isNew != null) builder.append(", isNew=").append(isNew);
    return builder.replace(0, 2, "Material{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Material, Builder> {
    public String id;

    public String thumbUrl;

    public String downloadUrl;

    public Integer categoryType;

    public Integer priority;

    public String name;

    public Integer tabId;

    public Boolean isNew;

    public Builder() {
    }

    /**
     * 素材编号
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * 缩略图
     */
    public Builder thumbUrl(String thumbUrl) {
      this.thumbUrl = thumbUrl;
      return this;
    }

    /**
     * 下载链接
     */
    public Builder downloadUrl(String downloadUrl) {
      this.downloadUrl = downloadUrl;
      return this;
    }

    /**
     * 类型 0:贴纸；1：表情
     */
    public Builder categoryType(Integer categoryType) {
      this.categoryType = categoryType;
      return this;
    }

    /**
     * 素材优先级；0为最高优先级，在最前面显示
     */
    public Builder priority(Integer priority) {
      this.priority = priority;
      return this;
    }

    /**
     * 素材名称,表情名称
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * 标签编号:从1开始，每种类型下又有多个标签；相同的tabId显示在同一个tab下。
     */
    public Builder tabId(Integer tabId) {
      this.tabId = tabId;
      return this;
    }

    /**
     * 是否是新素材
     */
    public Builder isNew(Boolean isNew) {
      this.isNew = isNew;
      return this;
    }

    @Override
    public Material build() {
      if (id == null
          || thumbUrl == null
          || downloadUrl == null
          || categoryType == null
          || priority == null) {
        throw Internal.missingRequiredFields(id, "id",
            thumbUrl, "thumbUrl",
            downloadUrl, "downloadUrl",
            categoryType, "categoryType",
            priority, "priority");
      }
      return new Material(id, thumbUrl, downloadUrl, categoryType, priority, name, tabId, isNew, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Material extends ProtoAdapter<Material> {
    ProtoAdapter_Material() {
      super(FieldEncoding.LENGTH_DELIMITED, Material.class);
    }

    @Override
    public int encodedSize(Material value) {
      return ProtoAdapter.STRING.encodedSizeWithTag(1, value.id)
          + ProtoAdapter.STRING.encodedSizeWithTag(2, value.thumbUrl)
          + ProtoAdapter.STRING.encodedSizeWithTag(3, value.downloadUrl)
          + ProtoAdapter.INT32.encodedSizeWithTag(4, value.categoryType)
          + ProtoAdapter.INT32.encodedSizeWithTag(5, value.priority)
          + (value.name != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, value.name) : 0)
          + (value.tabId != null ? ProtoAdapter.INT32.encodedSizeWithTag(7, value.tabId) : 0)
          + (value.isNew != null ? ProtoAdapter.BOOL.encodedSizeWithTag(8, value.isNew) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Material value) throws IOException {
      ProtoAdapter.STRING.encodeWithTag(writer, 1, value.id);
      ProtoAdapter.STRING.encodeWithTag(writer, 2, value.thumbUrl);
      ProtoAdapter.STRING.encodeWithTag(writer, 3, value.downloadUrl);
      ProtoAdapter.INT32.encodeWithTag(writer, 4, value.categoryType);
      ProtoAdapter.INT32.encodeWithTag(writer, 5, value.priority);
      if (value.name != null) ProtoAdapter.STRING.encodeWithTag(writer, 6, value.name);
      if (value.tabId != null) ProtoAdapter.INT32.encodeWithTag(writer, 7, value.tabId);
      if (value.isNew != null) ProtoAdapter.BOOL.encodeWithTag(writer, 8, value.isNew);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Material decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.id(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.thumbUrl(ProtoAdapter.STRING.decode(reader)); break;
          case 3: builder.downloadUrl(ProtoAdapter.STRING.decode(reader)); break;
          case 4: builder.categoryType(ProtoAdapter.INT32.decode(reader)); break;
          case 5: builder.priority(ProtoAdapter.INT32.decode(reader)); break;
          case 6: builder.name(ProtoAdapter.STRING.decode(reader)); break;
          case 7: builder.tabId(ProtoAdapter.INT32.decode(reader)); break;
          case 8: builder.isNew(ProtoAdapter.BOOL.decode(reader)); break;
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
    public Material redact(Material value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}