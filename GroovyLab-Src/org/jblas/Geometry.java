
package org.jblas;

/**
 * <p>General functions which are geometric in nature.</p>
 * 
 * <p>For example, computing all pairwise squared distances between all columns of a matrix.</p>
 */
public class Geometry {
	
	/**
	 * <p>Compute the pairwise squared distances between all columns of the two
	 * matrices.</p>
	 * 
	 * <p>An efficient way to do this is to observe that <i>(x-y)^2 = x^2 - 2xy - y^2</i>
	 * and to then properly carry out the computation with matrices.</p>
	 */
	public static DoubleMatrix pairwiseSquaredDistances(DoubleMatrix X, DoubleMatrix Y) {
		if (X.rows != Y.rows)
			throw new IllegalArgumentException(
					"Matrices must have same number of rows");
	
		DoubleMatrix XX = X.mul(X).columnSums();
		DoubleMatrix YY = Y.mul(Y).columnSums();
	
		DoubleMatrix Z = X.transpose().mmul(Y);
		Z.muli(-2.0); //Z.print();
		Z.addiColumnVector(XX);
		Z.addiRowVector(YY);
	
		return Z;
	}

        /** Center a vector (subtract mean from all elements (in-place). */
	public static DoubleMatrix center(DoubleMatrix x) {
		return x.subi(x.mean());
	}
	
        /** Center the rows of a matrix (in-place). */
	public static DoubleMatrix centerRows(DoubleMatrix x) {
                DoubleMatrix temp = new DoubleMatrix(x.columns);
		for (int r = 0; r < x.rows; r++)
			x.putRow(r, center(x.getRow(r, temp)));
		return x;
	}
	
        /** Center the columns of a matrix (in-place). */
	public static DoubleMatrix centerColumns(DoubleMatrix x) {
                DoubleMatrix temp = new DoubleMatrix(x.rows);
		for (int c = 0; c < x.columns; c++)
			x.putColumn(c, center(x.getColumn(c, temp)));
		return x;
	}
	
        /** Normalize a vector (scale such that its Euclidean norm is 1) (in-place). */
	public static DoubleMatrix normalize(DoubleMatrix x) {
		return x.divi(x.norm2());
	}

        /** Normalize the rows of a matrix (in-place). */
	public static DoubleMatrix normalizeRows(DoubleMatrix x) {
                DoubleMatrix temp = new DoubleMatrix(x.columns);
		for (int r = 0; r < x.rows; r++)
			x.putRow(r, normalize(x.getRow(r, temp)));
		return x;
	}
	
        /** Normalize the columns of a matrix (in-place). */
	public static DoubleMatrix normalizeColumns(DoubleMatrix x) {
                DoubleMatrix temp = new DoubleMatrix(x.rows);
		for (int c = 0; c < x.columns; c++)
			x.putColumn(c, normalize(x.getColumn(c, temp)));
		return x;
	}

//BEGIN
  // The code below has been automatically generated.
  // DO NOT EDIT!
	
	/**
	 * <p>Compute the pairwise squared distances between all columns of the two
	 * matrices.</p>
	 * 
	 * <p>An efficient way to do this is to observe that <i>(x-y)^2 = x^2 - 2xy - y^2</i>
	 * and to then properly carry out the computation with matrices.</p>
	 */
	public static FloatMatrix pairwiseSquaredDistances(FloatMatrix X, FloatMatrix Y) {
		if (X.rows != Y.rows)
			throw new IllegalArgumentException(
					"Matrices must have same number of rows");
	
		FloatMatrix XX = X.mul(X).columnSums();
		FloatMatrix YY = Y.mul(Y).columnSums();
	
		FloatMatrix Z = X.transpose().mmul(Y);
		Z.muli(-2.0f); //Z.print();
		Z.addiColumnVector(XX);
		Z.addiRowVector(YY);
	
		return Z;
	}

        /** Center a vector (subtract mean from all elements (in-place). */
	public static FloatMatrix center(FloatMatrix x) {
		return x.subi(x.mean());
	}
	
        /** Center the rows of a matrix (in-place). */
	public static FloatMatrix centerRows(FloatMatrix x) {
                FloatMatrix temp = new FloatMatrix(x.columns);
		for (int r = 0; r < x.rows; r++)
			x.putRow(r, center(x.getRow(r, temp)));
		return x;
	}
	
        /** Center the columns of a matrix (in-place). */
	public static FloatMatrix centerColumns(FloatMatrix x) {
                FloatMatrix temp = new FloatMatrix(x.rows);
		for (int c = 0; c < x.columns; c++)
			x.putColumn(c, center(x.getColumn(c, temp)));
		return x;
	}
	
        /** Normalize a vector (scale such that its Euclidean norm is 1) (in-place). */
	public static FloatMatrix normalize(FloatMatrix x) {
		return x.divi(x.norm2());
	}

        /** Normalize the rows of a matrix (in-place). */
	public static FloatMatrix normalizeRows(FloatMatrix x) {
                FloatMatrix temp = new FloatMatrix(x.columns);
		for (int r = 0; r < x.rows; r++)
			x.putRow(r, normalize(x.getRow(r, temp)));
		return x;
	}
	
        /** Normalize the columns of a matrix (in-place). */
	public static FloatMatrix normalizeColumns(FloatMatrix x) {
                FloatMatrix temp = new FloatMatrix(x.rows);
		for (int c = 0; c < x.columns; c++)
			x.putColumn(c, normalize(x.getColumn(c, temp)));
		return x;
	}

//END
}
