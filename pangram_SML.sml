fun checkString([], alphaHead) = false
  | checkString (#" "::stringTail, alphaHead) = checkString(stringTail,alphaHead)
  | checkString (#"\n"::stringTail,alphaHead) = checkString(stringTail,alphaHead)
  | checkString (#"."::stringTail, alphaHead) = checkString(stringTail,alphaHead) 
  |  checkString(stringHead::stringTail, alphaHead)=
     
    if(stringHead = alphaHead) then true else checkString(stringTail, alphaHead)
   ;								
fun line(stringHead::stringTail, []) = "true\n"
  | line([], alphaHead::alphaTail) = "false\n"
  | line (stringHead::stringTail, alphaHead::alphaTail) =
    if checkString(stringHead::stringTail,alphaHead) then line(stringHead::stringTail,alphaTail) else "false\n"
   ;
fun hw1(inFile : string, outFile : string)=
let
    val inStream = TextIO.openIn inFile
    val outStream = TextIO.openOut outFile
    val readLine = TextIO.inputLine inStream
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
			  
    fun helper(readLine : string option) =
      
	case readLine of
	    NONE => (TextIO.closeIn inStream; TextIO.closeOut outStream)
	  | SOME(c) => ( TextIO.output(outStream,line(explode(c), explode(alphabet)));
			 helper(TextIO.inputLine inStream))
  in
    helper(readLine)
  end;
   
