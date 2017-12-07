// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: protobuf.proto at 35:1
package com.giousa.protobufdemo.model;

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

public final class Test extends Message<Test, Test.Builder> {
  public static final ProtoAdapter<Test> ADAPTER = new ProtoAdapter_Test();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_TEST = "";

  public static final String DEFAULT_SEX = "";

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String test;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#STRING",
      label = WireField.Label.REQUIRED
  )
  public final String sex;

  public Test(String test, String sex) {
    this(test, sex, ByteString.EMPTY);
  }

  public Test(String test, String sex, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.test = test;
    this.sex = sex;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.test = test;
    builder.sex = sex;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof Test)) return false;
    Test o = (Test) other;
    return unknownFields().equals(o.unknownFields())
        && test.equals(o.test)
        && sex.equals(o.sex);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + test.hashCode();
      result = result * 37 + sex.hashCode();
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(", test=").append(test);
    builder.append(", sex=").append(sex);
    return builder.replace(0, 2, "Test{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<Test, Builder> {
    public String test;

    public String sex;

    public Builder() {
    }

    public Builder test(String test) {
      this.test = test;
      return this;
    }

    public Builder sex(String sex) {
      this.sex = sex;
      return this;
    }

    @Override
    public Test build() {
      if (test == null
          || sex == null) {
        throw Internal.missingRequiredFields(test, "test",
            sex, "sex");
      }
      return new Test(test, sex, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_Test extends ProtoAdapter<Test> {
    ProtoAdapter_Test() {
      super(FieldEncoding.LENGTH_DELIMITED, Test.class);
    }

    @Override
    public int encodedSize(Test value) {
      return ProtoAdapter.STRING.encodedSizeWithTag(1, value.test)
          + ProtoAdapter.STRING.encodedSizeWithTag(2, value.sex)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, Test value) throws IOException {
      ProtoAdapter.STRING.encodeWithTag(writer, 1, value.test);
      ProtoAdapter.STRING.encodeWithTag(writer, 2, value.sex);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public Test decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.test(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.sex(ProtoAdapter.STRING.decode(reader)); break;
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
    public Test redact(Test value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
