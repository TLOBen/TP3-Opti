/*********************************************
 * OPL 12.8.0.0 Model
 * Author: Julien CUSSET, Benjamin DAGOURET
 * Creation Date: Mar 26, 2018 at 1:45:48 PM
 *********************************************/

using CP;

int SIZE = ...;
int input[1..SIZE, 1..SIZE] = ...;

dvar int sudoku[1..SIZE, 1..SIZE] in 1..SIZE;

constraints {
  // Chiffres pour chaque ligne différente
  forall (i in 1..SIZE)
    allDifferent (all (j in 1..SIZE) sudoku[i,j]);

  // Chiffres pour chaque collone différente
  forall (j in 1..SIZE)
    allDifferent (all (i in 1..SIZE) sudoku [i,j]);

  // Chaque carré de 3*3 possède des chiffres différents
  forall (row, column in 0..2)
    allDifferent (all (x, y in 1..3) sudoku[3 * row + x, 3 * column + y]);

  // Le sudoku doit prendre la forme qu'il y a dans input
  forall (i, j in 1..SIZE)
    if (input[i, j] != 0) {
      sudoku[i, j] == input[i, j];
    }    
};