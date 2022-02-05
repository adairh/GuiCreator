//must have this piece of code for inventory to work, put it in your Listener class
@EventHandler
  public void onClick(InventoryClickEvent event) {
      Player p = (Player) event.getWhoClicked();
      if (GuiManager.checkGui(event.getView().getTitle())) {
          GuiManager manager = GuiManager.getGui(event.getView().getTitle());
          assert manager != null;
          manager.onClick(event);
      }
  }

  @EventHandler
  public void onClose(InventoryCloseEvent event) throws Exception {
      if (GuiManager.checkGui(event.getView().getTitle())) {
          GuiManager manager = GuiManager.getGui(event.getView().getTitle());
          assert manager != null;
          if (manager.isRealClose()){
              manager.removeGui();
          }
      }
  }
//With this piece of code, this listener in per child class with was initialized before will auto register together, no need to register the event again and again for per class!
