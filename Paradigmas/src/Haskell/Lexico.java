/* The following code was generated by JFlex 1.6.1 */

package Haskell;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>C:/Users/Aylin/Documents/NetBeansProjects/Paradigmas/src/Haskell/Lexico.jflex</tt>
 */
class Lexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\17\1\7\1\70\1\70\1\6\22\0\1\17\1\55\1\3"+
    "\1\0\1\51\1\66\1\60\1\4\1\56\1\57\1\12\1\46\1\61"+
    "\1\47\1\67\1\11\1\2\11\2\1\50\1\0\1\53\1\54\1\52"+
    "\2\0\1\26\1\1\1\23\1\24\1\25\1\32\1\43\1\44\1\37"+
    "\2\1\1\27\1\34\1\33\1\41\1\40\1\45\1\30\1\21\1\31"+
    "\1\22\1\42\1\1\1\35\2\1\1\64\1\10\1\65\1\0\1\1"+
    "\1\0\1\26\1\1\1\23\1\24\1\25\1\32\1\43\1\44\1\37"+
    "\2\1\1\27\1\34\1\33\1\41\1\40\1\45\1\30\1\21\1\31"+
    "\1\22\1\42\1\1\1\35\2\1\1\62\1\5\1\63\7\0\1\70"+
    "\73\0\1\1\7\0\1\1\3\0\1\1\5\0\1\1\6\0\1\1"+
    "\6\0\1\1\7\0\1\1\3\0\1\1\5\0\1\1\6\0\1\1"+
    "\65\0\2\36\115\0\1\20\u1e98\0\1\13\1\14\2\0\1\15\1\16"+
    "\12\0\1\70\1\70\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\3\1\1\4\1\5\1\6"+
    "\3\1\12\2\1\1\2\2\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\1\1\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\2\0\1\27\1\0"+
    "\1\30\3\0\1\31\1\32\3\0\1\30\2\0\1\27"+
    "\1\0\5\2\1\0\7\2\1\0\1\2\1\33\1\0"+
    "\1\33\3\2\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\3\0\2\32\3\0\1\44\1\2\1\44"+
    "\1\0\2\2\1\0\2\2\1\0\1\2\1\45\2\46"+
    "\1\47\5\2\1\50\2\51\1\0\1\2\1\52\1\2"+
    "\5\0\2\53\2\54\1\2\2\55\1\56\2\57\2\2"+
    "\1\60\1\61\1\0\1\2\2\62\1\2\1\0\1\63"+
    "\1\64\3\2\2\65\1\2\1\66\1\2\1\67\2\70"+
    "\2\2\1\71\1\72";

  private static int [] zzUnpackAction() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\71\0\162\0\253\0\344\0\u011d\0\u0156\0\71"+
    "\0\u018f\0\71\0\u01c8\0\u0201\0\u023a\0\u0273\0\u02ac\0\u02e5"+
    "\0\u031e\0\u0357\0\u0390\0\u03c9\0\u0402\0\u043b\0\u0474\0\u04ad"+
    "\0\u04e6\0\u051f\0\u0558\0\71\0\71\0\71\0\u0591\0\u05ca"+
    "\0\u0603\0\u063c\0\71\0\71\0\u0675\0\71\0\71\0\71"+
    "\0\71\0\71\0\71\0\u06ae\0\344\0\71\0\u06e7\0\71"+
    "\0\u0720\0\u0759\0\u0792\0\71\0\u07cb\0\u0804\0\u01c8\0\u083d"+
    "\0\u01c8\0\u0201\0\u0876\0\u0201\0\u08af\0\u08e8\0\u0921\0\u095a"+
    "\0\u0993\0\u09cc\0\u0a05\0\u0a3e\0\u0a77\0\u0ab0\0\u0ae9\0\u0b22"+
    "\0\u0b5b\0\u0b94\0\u0bcd\0\u0c06\0\71\0\u0c3f\0\162\0\u0c78"+
    "\0\u0cb1\0\u0cea\0\71\0\71\0\71\0\71\0\71\0\71"+
    "\0\71\0\u06ae\0\u0d23\0\u0d5c\0\u0d95\0\u0dce\0\71\0\u0e07"+
    "\0\u0e40\0\u0e79\0\71\0\u0eb2\0\162\0\u0eeb\0\u0f24\0\u0f5d"+
    "\0\u0f96\0\u0fcf\0\u1008\0\u1041\0\u107a\0\162\0\71\0\162"+
    "\0\162\0\u10b3\0\u10ec\0\u1125\0\u115e\0\u1197\0\162\0\71"+
    "\0\162\0\u11d0\0\u1209\0\162\0\u1242\0\u127b\0\u12b4\0\u12ed"+
    "\0\u1326\0\u135f\0\71\0\162\0\71\0\162\0\u1398\0\71"+
    "\0\162\0\162\0\71\0\162\0\u13d1\0\u140a\0\162\0\162"+
    "\0\u1443\0\u147c\0\71\0\162\0\u14b5\0\u14ee\0\71\0\71"+
    "\0\u1527\0\u1560\0\u1599\0\71\0\162\0\u15d2\0\71\0\u160b"+
    "\0\162\0\71\0\162\0\u1644\0\u167d\0\162\0\162";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\2\10\1\2"+
    "\1\11\1\12\1\13\1\2\2\14\1\10\1\15\1\16"+
    "\1\3\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\3\1\27\1\3\1\30\1\31\1\32\5\3"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\2\73\0\2\3\16\0\15\3\1\0\7\3"+
    "\25\0\1\4\64\0\1\54\1\0\3\55\1\56\65\55"+
    "\4\57\1\60\13\57\2\61\12\57\1\62\3\57\1\63"+
    "\30\57\5\0\1\64\74\0\1\65\1\66\56\0\4\67"+
    "\4\70\4\67\1\71\54\67\3\72\1\73\1\72\3\73"+
    "\6\72\1\74\52\72\22\0\1\75\47\0\2\3\16\0"+
    "\1\3\1\76\13\3\1\0\7\3\24\0\2\3\16\0"+
    "\5\3\1\77\7\3\1\0\7\3\24\0\2\3\16\0"+
    "\4\3\1\100\10\3\1\0\7\3\24\0\2\3\16\0"+
    "\6\3\1\101\3\3\1\102\2\3\1\0\7\3\24\0"+
    "\2\3\15\0\1\103\1\104\14\3\1\0\7\3\24\0"+
    "\2\3\16\0\4\3\1\105\10\3\1\0\7\3\24\0"+
    "\2\3\16\0\4\3\1\106\10\3\1\0\7\3\24\0"+
    "\2\3\16\0\7\3\1\107\5\3\1\0\5\3\1\110"+
    "\1\3\24\0\2\3\16\0\5\3\1\111\7\3\1\0"+
    "\7\3\24\0\2\3\16\0\5\3\1\112\7\3\1\113"+
    "\1\114\6\3\55\0\1\115\1\0\1\116\35\0\2\3"+
    "\16\0\11\3\1\117\1\3\1\120\1\3\1\0\7\3"+
    "\24\0\2\3\16\0\5\3\1\121\1\3\1\122\5\3"+
    "\1\0\7\3\71\0\1\123\76\0\1\124\70\0\1\125"+
    "\70\0\1\126\70\0\1\127\1\130\73\0\1\131\12\0"+
    "\1\132\66\0\4\57\1\60\70\57\1\60\40\57\1\133"+
    "\27\57\1\60\34\57\1\134\33\57\1\60\34\57\1\135"+
    "\27\57\5\65\1\0\1\136\1\137\61\65\12\140\1\141"+
    "\56\140\14\70\1\60\54\70\16\73\1\56\52\73\23\0"+
    "\1\142\10\0\1\143\35\0\2\3\16\0\2\3\1\144"+
    "\10\3\1\145\1\3\1\0\7\3\24\0\2\3\15\0"+
    "\1\146\1\147\5\3\1\150\6\3\1\0\7\3\24\0"+
    "\2\3\15\0\1\151\1\152\1\3\1\153\12\3\1\0"+
    "\7\3\24\0\2\3\15\0\1\154\1\155\14\3\1\0"+
    "\7\3\24\0\2\3\16\0\3\3\1\156\11\3\1\0"+
    "\7\3\46\0\1\157\46\0\2\3\16\0\2\3\1\160"+
    "\12\3\1\0\7\3\24\0\2\3\16\0\10\3\1\161"+
    "\1\3\1\162\2\3\1\0\7\3\24\0\2\3\16\0"+
    "\15\3\1\0\3\3\1\163\3\3\24\0\2\3\16\0"+
    "\1\3\1\164\13\3\1\0\7\3\24\0\2\3\16\0"+
    "\4\3\1\165\10\3\1\0\7\3\24\0\2\3\16\0"+
    "\6\3\1\166\6\3\1\0\7\3\24\0\2\3\16\0"+
    "\14\3\1\167\1\0\7\3\56\0\1\170\36\0\2\3"+
    "\16\0\12\3\1\171\2\3\1\0\7\3\63\0\1\172"+
    "\31\0\2\3\16\0\15\3\1\0\1\3\1\173\5\3"+
    "\24\0\2\3\16\0\7\3\1\174\5\3\1\0\7\3"+
    "\24\0\2\3\16\0\15\3\1\0\2\3\1\175\4\3"+
    "\23\0\4\57\1\60\23\57\1\176\44\57\1\60\17\57"+
    "\1\177\50\57\1\60\24\57\1\200\37\57\7\0\1\201"+
    "\61\0\12\140\1\202\56\140\11\0\1\137\1\141\101\0"+
    "\1\203\46\0\2\3\16\0\2\3\1\204\12\3\1\0"+
    "\7\3\50\0\1\205\44\0\2\3\16\0\4\3\1\206"+
    "\10\3\1\0\7\3\24\0\2\3\16\0\2\3\1\207"+
    "\12\3\1\0\7\3\46\0\1\210\46\0\2\3\16\0"+
    "\2\3\1\211\12\3\1\0\7\3\24\0\2\3\16\0"+
    "\2\3\1\212\12\3\1\0\7\3\50\0\1\213\44\0"+
    "\2\3\16\0\4\3\1\214\10\3\1\0\7\3\24\0"+
    "\2\3\16\0\15\3\1\0\4\3\1\215\2\3\24\0"+
    "\2\3\16\0\4\3\1\216\10\3\1\0\7\3\24\0"+
    "\2\3\16\0\4\3\1\217\10\3\1\0\7\3\24\0"+
    "\2\3\16\0\12\3\1\220\2\3\1\0\7\3\24\0"+
    "\2\3\15\0\1\221\1\222\14\3\1\0\7\3\53\0"+
    "\1\223\41\0\2\3\16\0\7\3\1\224\5\3\1\0"+
    "\7\3\24\0\2\3\16\0\3\3\1\225\11\3\1\0"+
    "\7\3\23\0\4\57\1\60\24\57\1\226\43\57\1\227"+
    "\70\57\1\230\64\57\10\0\1\137\60\0\11\140\1\137"+
    "\1\202\56\140\1\0\2\3\16\0\1\3\1\231\13\3"+
    "\1\0\7\3\24\0\2\3\16\0\10\3\1\232\4\3"+
    "\1\0\7\3\24\0\2\3\16\0\7\3\1\233\5\3"+
    "\1\0\7\3\50\0\1\234\44\0\2\3\16\0\4\3"+
    "\1\235\10\3\1\0\7\3\24\0\2\3\16\0\1\3"+
    "\1\236\13\3\1\0\7\3\23\0\4\57\1\237\64\57"+
    "\1\0\2\3\16\0\6\3\1\240\6\3\1\0\7\3"+
    "\24\0\2\3\16\0\15\3\1\0\5\3\1\241\1\3"+
    "\24\0\2\3\15\0\1\242\1\243\14\3\1\0\7\3"+
    "\24\0\2\3\16\0\2\3\1\244\12\3\1\0\7\3"+
    "\24\0\2\3\16\0\5\3\1\245\7\3\1\0\7\3"+
    "\24\0\2\3\16\0\10\3\1\246\4\3\1\0\7\3"+
    "\24\0\2\3\16\0\7\3\1\247\5\3\1\0\7\3"+
    "\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5814];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\5\1\1\11\1\1\1\11\21\1\3\11"+
    "\4\1\2\11\1\1\6\11\2\0\1\11\1\0\1\11"+
    "\3\0\1\11\1\1\3\0\1\1\2\0\1\1\1\0"+
    "\5\1\1\0\7\1\1\0\1\1\1\11\1\0\4\1"+
    "\7\11\1\1\3\0\1\1\1\11\3\0\1\11\2\1"+
    "\1\0\2\1\1\0\2\1\1\0\2\1\1\11\10\1"+
    "\1\11\1\1\1\0\3\1\5\0\1\11\1\1\1\11"+
    "\2\1\1\11\2\1\1\11\5\1\1\0\1\1\1\11"+
    "\2\1\1\0\2\11\3\1\1\11\2\1\1\11\2\1"+
    "\1\11\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
public String lexeme;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexico(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 280) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return new Symbol(sym.ERROR,yycolumn, yyline,new String(yytext()));
            }
          case 59: break;
          case 2: 
            { lexeme=yytext(); return new Symbol(sym.id,yycolumn, yyline, new String(yytext()));
            }
          case 60: break;
          case 3: 
            { lexeme=yytext(); return new Symbol(sym.numero,yycolumn, yyline,new String(yytext()));
            }
          case 61: break;
          case 4: 
            { /*Ignore*/
            }
          case 62: break;
          case 5: 
            { return new Symbol(sym.div  ,yycolumn, yyline,new String(yytext()));
            }
          case 63: break;
          case 6: 
            { return new Symbol(sym.por  ,yycolumn, yyline,new String(yytext()));
            }
          case 64: break;
          case 7: 
            { return new Symbol(sym.mas  ,yycolumn, yyline,new String(yytext()));
            }
          case 65: break;
          case 8: 
            { return new Symbol(sym.menos  ,yycolumn, yyline,new String(yytext()));
            }
          case 66: break;
          case 9: 
            { return new Symbol(sym.dosPuntos  ,yycolumn, yyline,new String(yytext()));
            }
          case 67: break;
          case 10: 
            { return new Symbol(sym.dollar  ,yycolumn, yyline,new String(yytext()));
            }
          case 68: break;
          case 11: 
            { return new Symbol(sym.mayor, yycolumn, yyline,new String(yytext()));
            }
          case 69: break;
          case 12: 
            { return new Symbol(sym.menor, yycolumn, yyline,new String(yytext()));
            }
          case 70: break;
          case 13: 
            { return new Symbol(sym.igual, yycolumn, yyline,new String(yytext()));
            }
          case 71: break;
          case 14: 
            { return new Symbol(sym.not, yycolumn, yyline,new String(yytext()));
            }
          case 72: break;
          case 15: 
            { return new Symbol(sym.parentesisA, yycolumn, yyline,new String(yytext()));
            }
          case 73: break;
          case 16: 
            { return new Symbol(sym.parentesisC, yycolumn, yyline,new String(yytext()));
            }
          case 74: break;
          case 17: 
            { return new Symbol(sym.coma ,yycolumn, yyline,new String(yytext()));
            }
          case 75: break;
          case 18: 
            { return new Symbol(sym.llaveA  ,yycolumn, yyline,new String(yytext()));
            }
          case 76: break;
          case 19: 
            { return new Symbol(sym.llaveC  ,yycolumn, yyline,new String(yytext()));
            }
          case 77: break;
          case 20: 
            { return new Symbol(sym.corcheteA, yycolumn, yyline,new String(yytext()));
            }
          case 78: break;
          case 21: 
            { return new Symbol(sym.corcheteC, yycolumn, yyline,new String(yytext()));
            }
          case 79: break;
          case 22: 
            { return new Symbol(sym.porcentaje  ,yycolumn, yyline,new String(yytext()));
            }
          case 80: break;
          case 23: 
            { lexeme=yytext(); return new Symbol(sym.cadena ,yycolumn, yyline,new String(yytext()));
            }
          case 81: break;
          case 24: 
            { lexeme=yytext(); return new Symbol(sym.caracter ,yycolumn, yyline,new String(yytext()));
            }
          case 82: break;
          case 25: 
            { return new Symbol(sym.or, yycolumn, yyline,new String(yytext()));
            }
          case 83: break;
          case 26: 
            { 
            }
          case 84: break;
          case 27: 
            { return new Symbol(sym.si, yycolumn, yyline,new String(yytext()));
            }
          case 85: break;
          case 28: 
            { return new Symbol(sym.concatenar  ,yycolumn, yyline,new String(yytext()));
            }
          case 86: break;
          case 29: 
            { return new Symbol(sym.menorIgual, yycolumn, yyline,new String(yytext()));
            }
          case 87: break;
          case 30: 
            { return new Symbol(sym.mayorIgual, yycolumn, yyline,new String(yytext()));
            }
          case 88: break;
          case 31: 
            { return new Symbol(sym.igualDoble, yycolumn, yyline,new String(yytext()));
            }
          case 89: break;
          case 32: 
            { return new Symbol(sym.diferente, yycolumn, yyline,new String(yytext()));
            }
          case 90: break;
          case 33: 
            { return new Symbol(sym.posicion  ,yycolumn, yyline,new String(yytext()));
            }
          case 91: break;
          case 34: 
            { return new Symbol(sym.and, yycolumn, yyline,new String(yytext()));
            }
          case 92: break;
          case 35: 
            { lexeme=yytext(); return new Symbol(sym.decimal, yycolumn, yyline,new String(yytext()));
            }
          case 93: break;
          case 36: 
            { return new Symbol(sym.sum, yycolumn, yyline,new String(yytext()));
            }
          case 94: break;
          case 37: 
            { return new Symbol(sym.end, yycolumn, yyline,new String(yytext()));
            }
          case 95: break;
          case 38: 
            { return new Symbol(sym.asc, yycolumn, yyline,new String(yytext()));
            }
          case 96: break;
          case 39: 
            { return new Symbol(sym.let,yycolumn, yyline, new String(yytext()));
            }
          case 97: break;
          case 40: 
            { return new Symbol(sym.max  ,yycolumn, yyline,new String(yytext()));
            }
          case 98: break;
          case 41: 
            { return new Symbol(sym.min  ,yycolumn, yyline,new String(yytext()));
            }
          case 99: break;
          case 42: 
            { return new Symbol(sym.par, yycolumn, yyline,new String(yytext()));
            }
          case 100: break;
          case 43: 
            { return new Symbol(sym.succ, yycolumn, yyline, new String(yytext()));
            }
          case 101: break;
          case 44: 
            { return new Symbol(sym.caso, yycolumn, yyline,new String(yytext()));
            }
          case 102: break;
          case 45: 
            { return new Symbol(sym.desc, yycolumn, yyline,new String(yytext()));
            }
          case 103: break;
          case 46: 
            { return new Symbol(sym.decc,yycolumn, yyline, new String(yytext()));
            }
          case 104: break;
          case 47: 
            { return new Symbol(sym.sino, yycolumn, yyline,new String(yytext()));
            }
          case 105: break;
          case 48: 
            { return new Symbol(sym.verdadero, yycolumn, yyline,new String(yytext()));
            }
          case 106: break;
          case 49: 
            { return new Symbol(sym.entonces, yycolumn, yyline,new String(yytext()));
            }
          case 107: break;
          case 50: 
            { return new Symbol(sym.impr, yycolumn, yyline,new String(yytext()));
            }
          case 108: break;
          case 51: 
            { return new Symbol(sym.mod  ,yycolumn, yyline,new String(yytext()));
            }
          case 109: break;
          case 52: 
            { return new Symbol(sym.pot  ,yycolumn, yyline,new String(yytext()));
            }
          case 110: break;
          case 53: 
            { return new Symbol(sym.falso, yycolumn, yyline,new String(yytext()));
            }
          case 111: break;
          case 54: 
            { return new Symbol(sym.sqrt  ,yycolumn, yyline,new String(yytext()));
            }
          case 112: break;
          case 55: 
            { return new Symbol(sym.length, yycolumn, yyline,new String(yytext()));
            }
          case 113: break;
          case 56: 
            { return new Symbol(sym.revers, yycolumn, yyline,new String(yytext()));
            }
          case 114: break;
          case 57: 
            { return new Symbol(sym.product, yycolumn, yyline,new String(yytext()));
            }
          case 115: break;
          case 58: 
            { return new Symbol(sym.calcular  ,yycolumn, yyline,new String(yytext()));
            }
          case 116: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
