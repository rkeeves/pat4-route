package com.rkeeves.pat4.io;

import java.io.IOException;

public interface Pat4FileDataInput {
	
	public boolean readBoolean() throws IOException;

	public byte readByte() throws IOException;
	
	public char readChar() throws IOException;
	
	public int readInt() throws IOException;
	
	public float readFloat() throws IOException;
	
	public String readVarLenNulTerminatedString() throws IOException;
}
