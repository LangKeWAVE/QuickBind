package com.hughbone.quickselect;

import com.hughbone.quickselect.gui.HughButton;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;

public class SaveJson {
    public static void save() {
        JSONArray jsonArray = new JSONArray();
        for (HughButton hb : HughButton.hughButtonList) {
            try {
                JSONObject buttonField = new JSONObject();
                buttonField.put("hover-text", hb.toolText);
                buttonField.put("chat-command", hb.chatCommand);
                buttonField.put("hotkey", hb.keyBinding.getTranslationKey());

                JSONObject buttonObject = new JSONObject();
                buttonObject.put(hb.getLabel().getString(), buttonField);
                jsonArray.add(buttonObject);

            } catch (Exception e){}
        }

        try {
            FileWriter file = new FileWriter("config" + File.separator + "quickbind.json");
            file.write(jsonArray.toJSONString());
            file.flush();

        }catch (Exception e){
        }

    }
}
