package com.example.niklas.whostarts;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import java.util.Date;

public class Preferences {

   private static final String PREFERENCE_JSON_LIST  		= "json_list";
   private static final String PREFERENCE_STRING_ARRAY  	= "string_array";
   private static final String PREFERENCE_STANDARD  	    = "standard";
   private static final String PREFERENCE_FANTASY  	        = "fantasy";
   private static final String PREFERENCE_NERD  	        = "nerd";
   private static final String PREFERENCE_DARWIN  	        = "darwin";
   private static final String PREFERENCE_OWN  	            = "own";

   private static Preferences instance = null;
   static SharedPreferences settings = null;
   Editor edit = null;


   public static Preferences get(Context context) {
      if(instance == null) {
         instance = new Preferences(context);
      }
      return instance;
   }

   private Preferences(Context context) {
      settings = PreferenceManager.getDefaultSharedPreferences(context);
      edit = settings.edit();
   }

   public void clearPreferences() {
      edit.clear();
      edit.commit();
   }


   public void saveJSONstring(String json) {
      edit.putString(PREFERENCE_JSON_LIST, json);
      edit.commit();
   }
   public String getJSONstring()  {
      return settings.getString(PREFERENCE_JSON_LIST,"");
   }

   public void saveStringArray(String array) {
      edit.putString(PREFERENCE_STRING_ARRAY, array);
      edit.commit();
   }

   /**string Array**/
   public String getStringArray()  {
      return settings.getString(PREFERENCE_STRING_ARRAY,"");
   }

   public void addToStringArray (String addString){
      edit.putString(PREFERENCE_STRING_ARRAY, getStringArray() +"¤"+ addString );
      edit.commit();
   }

   public void resetStringArray (){
      edit.putString(PREFERENCE_STRING_ARRAY,"");
      edit.commit();
   }
   /** standard **/
   public boolean getStandard()  {
      return settings.getBoolean(PREFERENCE_STANDARD,true);
   }

   public void saveStandard (boolean value){
      edit.putBoolean(PREFERENCE_STANDARD, value);
      edit.commit();
   }

   /** fantasy **/
   public boolean getFantasy()  {
      return settings.getBoolean(PREFERENCE_FANTASY,true);
   }

   public void saveFantasy (boolean value){
      edit.putBoolean(PREFERENCE_FANTASY, value);
      edit.commit();
   }

   /** nerd **/
   public boolean getNerd()  {
      return settings.getBoolean(PREFERENCE_NERD,true);
   }

   public void saveNerd (boolean value){
      edit.putBoolean(PREFERENCE_NERD, value);
      edit.commit();
   }

   /** darwin **/
   public boolean getDarwin()  {
      return settings.getBoolean(PREFERENCE_DARWIN,true);
   }

   public void saveDarwin (boolean value){
      edit.putBoolean(PREFERENCE_DARWIN, value);
      edit.commit();
   }

   /** Own **/
   public boolean getOwn()  {
      return settings.getBoolean(PREFERENCE_OWN,true);
   }

   public void saveOwn (boolean value){
      edit.putBoolean(PREFERENCE_OWN, value);
      edit.commit();
   }

}
