
public class Lasermaze implements  Testable {
  int columnMultiplier = 1; // values -1, 0, 1
  int rowMultiplier = 0; // values -1, 0, 1
  byte modifier = 0;


  public int evaluate(String input) {
    /*
     * Implement your lazermaze here.
     * Feel free to create other classes and files in src/main/java/**
     */

    char value;
    int byteLocation;
    int distance = 0;
    byte[] usedSpace = new byte[input.length()]; //defaults to 0000 0000
    int startingPosition = input.indexOf("@");
    if (startingPosition == -128){
      return -1;
    }

    String[] inputValues= input.split("\n");
    int rowLength = inputValues.length;
    int columnLength = inputValues[0].length();

    int activeRow = startingPosition / (columnLength + 1);
    int activeColumn = inputValues[activeRow].indexOf("@");
    if (activeColumn == -1){ //error check
      return -128;
    }
    while(activeColumn < columnLength && activeRow < rowLength && activeColumn >= 0 && activeRow >= 0){
      distance ++;
      value = inputValues[activeRow].charAt(activeColumn);
      nextStep(value); //modifies the step direction

      // Visited Bit updates here
      byteLocation = activeRow * (columnLength + 1 ) + activeColumn;
      if((usedSpace[byteLocation] & modifier) != 0) { // check for loop
        return -1;
      }
      // update
      usedSpace[byteLocation] |= modifier;
      activeRow += rowMultiplier;
      activeColumn += columnMultiplier;
    }
    return distance;
  }

  private void nextStep(char input){
    int swapHolder;

    switch (input) {
      case 'O':
        columnMultiplier = columnMultiplier * -1;
        rowMultiplier = rowMultiplier * -1;
        break;
      case '^':
        columnMultiplier = 0;
        rowMultiplier = -1;
        break;
      case 'v':
        columnMultiplier = 0;
        rowMultiplier = 1;
        break;
      case '<':
        columnMultiplier = -1;
        rowMultiplier = 0;
        break;
      case '>':
        columnMultiplier = 1;
        rowMultiplier = 0;
        break;
      case '\\':
        swapHolder = columnMultiplier;
        columnMultiplier = rowMultiplier;
        rowMultiplier = swapHolder;
        break;
      case '/':
        swapHolder = columnMultiplier * -1;
        columnMultiplier = rowMultiplier * -1;
        rowMultiplier = swapHolder;
        break;
      default:
        break;
    }
    //set binary path modifier
    if(columnMultiplier == 1 ){
      modifier = 1;
    } else if(columnMultiplier == -1){
      modifier = 2;
    } else if(rowMultiplier == 1){
      modifier = 4;
    } else if(rowMultiplier == -1){
      modifier = 8;
    }
    return;
  }
}

