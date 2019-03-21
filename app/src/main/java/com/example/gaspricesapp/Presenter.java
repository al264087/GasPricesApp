package com.example.gaspricesapp;

import Model.IModel;

class Presenter {


   private static IModel model;
   private static IView view;

   public Presenter (IView view , IModel model)
   {
       this.view = view;
       this.model = model;
   }

}
