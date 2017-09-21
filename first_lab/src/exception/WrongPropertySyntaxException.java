package exception;

class WrongPropertySyntaxException  extends IllegalArgumentException
{
	public String message;
    
	  // Parameterless Constructor
	  public WrongPropertySyntaxException () {}
	
	  // Constructor that accepts a message
	  public WrongPropertySyntaxException (String message)
	  {
	     super(message);
	      this.message = message;
	  }
	
	  // Overrides Exception's getMessage()
	  @Override
	  public String toString(){
	      return message;
	  }
 }