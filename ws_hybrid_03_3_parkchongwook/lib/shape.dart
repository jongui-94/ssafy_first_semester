import 'dart:math';

class Position {
  int x=0;
  int y=0;

  double distanceTo(Position other){
    return sqrt(other.x * other.x + other.y * other.y);
  }
}

class Square {
  int width =0;
  int height =0;

  int getArea(){
    return width * height;
  }
}

class CalcSquare extends Square with Position{
  CalcSquare(int getX, int getY){
    x = getX;
    width = getX;
    y = getY;
    height = getY;
  }
}