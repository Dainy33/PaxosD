package com.dainy33.message;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by dainy33 on 2019-04-16.
 */
public class PaxosMsgTypeSerializer implements JsonSerializer<PaxosMsgTypeEnum>,JsonDeserializer<PaxosMsgTypeEnum> {
    @Override
    public PaxosMsgTypeEnum deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.getAsInt() < PaxosMsgTypeEnum.values().length)
            return PaxosMsgTypeEnum.values()[jsonElement.getAsInt()];
        return null;
    }

    @Override
    public JsonElement serialize(PaxosMsgTypeEnum paxosMsgTypeEnum, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(paxosMsgTypeEnum.ordinal());
    }
}
