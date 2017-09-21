package exception;

class WrongPropertySyntaxException  extends IllegalArgumentException
{
    
	  // Parameterless Constructor
	  public WrongPropertySyntaxException () {}
	
	  // Constructor that accepts a message
	  public WrongPropertySyntaxException (String message)
	  {
	     super(message);
	  }
 }