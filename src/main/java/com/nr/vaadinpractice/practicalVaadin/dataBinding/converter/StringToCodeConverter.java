package com.nr.vaadinpractice.practicalVaadin.dataBinding.converter;

import com.nr.vaadinpractice.practicalVaadin.dataBinding.entity.Code;
import com.nr.vaadinpractice.practicalVaadin.dataBinding.entity.Type;
import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class StringToCodeConverter implements Converter<String, Code> {

  @Override
  public Result<Code> convertToModel(String value, ValueContext context) { //setter
    for (Type type : Type.values()) {
      if (value.startsWith(type.toString())) {
        Code code = new Code(type, value.substring(type.toString().length()));
        return Result.ok(code);
      }
    }
    return Result.error("Error parsing the code");
  }

  @Override
  public String convertToPresentation(Code code, ValueContext context) { //getter
    return code.getType().toString() + code.getNumber();
  }
}
