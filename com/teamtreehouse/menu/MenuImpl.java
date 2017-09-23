package com.teamtreehouse.menu;

import java.util.List;
import java.util.Arrays;

public class MenuImpl implements MenuInterface{
  public void displayOptions() {
    System.out.printf("Select from one of the follow options: %n");
    List<String> options = Arrays.asList(
      "1. Create a new team",
      "2. Add players to a team",
      "3. Remove players from a team",
      "4. Exit"
    );    
    for (String option: options) {
      System.out.println(option);
    }
  }
  
  public int getSelectedOption() {
  
  }
//  
//  public void runSelectedOption() {
//  
//  }
}