package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.io.InputStream;
import java.util.Scanner;

@Route(UploadFieldView.ROUTE)
@PageTitle(UploadFieldView.TITLE)
public class UploadFieldView extends Composite<Component> {

  public static final String ROUTE = "uploadFieldView";
  public static final String TITLE = "UploadField View";

  @Override
  protected Component initContent() { //For further info check Practical vaadin book
    MemoryBuffer receiver = new MemoryBuffer();
    Upload upload = new Upload(receiver);
    upload.setAcceptedFileTypes("text/plain");
    upload.addSucceededListener(e -> {
      InputStream iS = receiver.getInputStream();
      long count = new Scanner(iS).findAll("[Aa]").count();
      Notification.show("A x " + count + " times");
    });
    return new VerticalLayout(upload);
  }
}
