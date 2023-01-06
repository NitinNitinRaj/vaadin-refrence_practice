package com.nr.vaadinpractice.practicalVaadin.UIComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(MenusView.ROUTE)
@PageTitle(MenusView.TITLE)
public class MenusView extends Composite<Component> {

  public static final String ROUTE = "menusView";
  public static final String TITLE = "Menus View";

  @Override
  protected Component initContent() {
    MenuBar menuBar = new MenuBar();
    MenuItem file = menuBar.addItem("File");
    MenuItem newItem = file.getSubMenu().addItem("New");

    file.getSubMenu().addItem("Open");

    newItem
      .getSubMenu()
      .addItem(
        "Pdf",
        e -> {
          e.getSource().setCheckable(true);
        }
      );
    newItem
      .getSubMenu()
      .addItem(
        "Docx",
        e -> {
          e.getSource().setEnabled(false);
        }
      );

    MenuItem edit = menuBar.addItem("Edit");
    edit.getSubMenu().addItem("Copy");
    MenuItem pasteItem = edit.getSubMenu().addItem("Paste");
    pasteItem.getSubMenu().addItem("Copy Paste");
    pasteItem
      .getSubMenu()
      .addItem(
        "Cut Paste",
        e -> {
          Notification.show(e.getSource().getText());
        }
      );

    var target = new HorizontalLayout(new Text("Right click here"));

    ContextMenu contextMenu = new ContextMenu(target);
    contextMenu.addItem("Copy");
    contextMenu.addItem("Paste");

    return new VerticalLayout(menuBar, target);
  }
}
