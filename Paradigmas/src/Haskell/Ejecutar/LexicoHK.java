/* The following code was generated by JFlex 1.6.1 */

package Haskell.Ejecutar;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>C:/Users/Aylin/Documents/NetBeansProjects/Paradigmas/src/Haskell/Ejecutar/LexicoHK.jflex</tt>
 */
public class LexicoHK implements java_cup.runtime.Scanner {

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
    "\11\0\1\17\1\7\1\71\1\71\1\6\22\0\1\17\1\55\1\3"+
    "\1\0\1\51\1\66\1\60\1\4\1\56\1\57\1\12\1\46\1\61"+
    "\1\47\1\70\1\11\1\2\11\2\1\50\1\67\1\53\1\54\1\52"+
    "\2\0\1\26\1\1\1\23\1\24\1\25\1\32\1\43\1\44\1\37"+
    "\2\1\1\27\1\34\1\33\1\41\1\40\1\45\1\30\1\21\1\31"+
    "\1\22\1\42\1\1\1\35\2\1\1\64\1\10\1\65\1\0\1\1"+
    "\1\0\1\26\1\1\1\23\1\24\1\25\1\32\1\43\1\44\1\37"+
    "\2\1\1\27\1\34\1\33\1\41\1\40\1\45\1\30\1\21\1\31"+
    "\1\22\1\42\1\1\1\35\2\1\1\62\1\5\1\63\7\0\1\71"+
    "\73\0\1\1\7\0\1\1\3\0\1\1\5\0\1\1\6\0\1\1"+
    "\6\0\1\1\7\0\1\1\3\0\1\1\5\0\1\1\6\0\1\1"+
    "\65\0\2\36\115\0\1\20\u1e98\0\1\13\1\14\2\0\1\15\1\16"+
    "\12\0\1\71\1\71\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

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
    "\1\7\3\1\12\2\1\1\2\2\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\1"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\2\0"+
    "\1\31\1\0\1\32\3\0\1\33\1\34\3\0\1\32"+
    "\2\0\1\31\1\0\5\2\1\0\7\2\1\0\1\2"+
    "\1\35\1\0\1\35\3\2\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\3\0\2\34\3\0\1\46"+
    "\1\2\1\46\1\0\2\2\1\0\2\2\1\0\1\2"+
    "\1\47\2\50\1\51\5\2\1\52\2\53\1\0\1\2"+
    "\1\54\1\2\5\0\2\55\2\56\1\2\2\57\1\60"+
    "\2\61\2\2\1\62\1\63\1\0\1\2\2\64\1\2"+
    "\1\0\1\65\1\66\3\2\2\67\1\2\1\70\1\2"+
    "\1\71\2\72\2\2\1\73\1\74";

  private static int [] zzUnpackAction() {
    int [] result = new int[169];
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
    "\0\0\0\72\0\164\0\256\0\350\0\u0122\0\u015c\0\72"+
    "\0\72\0\u0196\0\72\0\u01d0\0\u020a\0\u0244\0\u027e\0\u02b8"+
    "\0\u02f2\0\u032c\0\u0366\0\u03a0\0\u03da\0\u0414\0\u044e\0\u0488"+
    "\0\u04c2\0\u04fc\0\u0536\0\u0570\0\72\0\72\0\72\0\u05aa"+
    "\0\u05e4\0\u061e\0\u0658\0\72\0\72\0\u0692\0\72\0\72"+
    "\0\72\0\72\0\72\0\72\0\72\0\u06cc\0\350\0\72"+
    "\0\u0706\0\72\0\u0740\0\u077a\0\u07b4\0\72\0\u07ee\0\u0828"+
    "\0\u01d0\0\u0862\0\u01d0\0\u020a\0\u089c\0\u020a\0\u08d6\0\u0910"+
    "\0\u094a\0\u0984\0\u09be\0\u09f8\0\u0a32\0\u0a6c\0\u0aa6\0\u0ae0"+
    "\0\u0b1a\0\u0b54\0\u0b8e\0\u0bc8\0\u0c02\0\u0c3c\0\72\0\u0c76"+
    "\0\164\0\u0cb0\0\u0cea\0\u0d24\0\72\0\72\0\72\0\72"+
    "\0\72\0\72\0\72\0\u06cc\0\u0d5e\0\u0d98\0\u0dd2\0\u0e0c"+
    "\0\72\0\u0e46\0\u0e80\0\u0eba\0\72\0\u0ef4\0\164\0\u0f2e"+
    "\0\u0f68\0\u0fa2\0\u0fdc\0\u1016\0\u1050\0\u108a\0\u10c4\0\164"+
    "\0\72\0\164\0\164\0\u10fe\0\u1138\0\u1172\0\u11ac\0\u11e6"+
    "\0\164\0\72\0\164\0\u1220\0\u125a\0\164\0\u1294\0\u12ce"+
    "\0\u1308\0\u1342\0\u137c\0\u13b6\0\72\0\164\0\72\0\164"+
    "\0\u13f0\0\72\0\164\0\164\0\72\0\164\0\u142a\0\u1464"+
    "\0\164\0\164\0\u149e\0\u14d8\0\72\0\164\0\u1512\0\u154c"+
    "\0\72\0\72\0\u1586\0\u15c0\0\u15fa\0\72\0\164\0\u1634"+
    "\0\72\0\u166e\0\164\0\72\0\164\0\u16a8\0\u16e2\0\164"+
    "\0\164";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[169];
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
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\2\1\12\1\13\1\14\1\2\2\15\1\10\1\16"+
    "\1\17\1\3\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\3\1\30\1\3\1\31\1\32\1\33"+
    "\5\3\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\1\2\74\0\2\3\16\0\15\3"+
    "\1\0\7\3\26\0\1\4\65\0\1\56\1\0\3\57"+
    "\1\60\66\57\4\61\1\62\13\61\2\63\12\61\1\64"+
    "\3\61\1\65\31\61\5\0\1\66\75\0\1\67\1\70"+
    "\57\0\4\71\4\72\4\71\1\73\55\71\3\74\1\75"+
    "\1\74\3\75\6\74\1\76\53\74\22\0\1\77\50\0"+
    "\2\3\16\0\1\3\1\100\13\3\1\0\7\3\25\0"+
    "\2\3\16\0\5\3\1\101\7\3\1\0\7\3\25\0"+
    "\2\3\16\0\4\3\1\102\10\3\1\0\7\3\25\0"+
    "\2\3\16\0\6\3\1\103\3\3\1\104\2\3\1\0"+
    "\7\3\25\0\2\3\15\0\1\105\1\106\14\3\1\0"+
    "\7\3\25\0\2\3\16\0\4\3\1\107\10\3\1\0"+
    "\7\3\25\0\2\3\16\0\4\3\1\110\10\3\1\0"+
    "\7\3\25\0\2\3\16\0\7\3\1\111\5\3\1\0"+
    "\5\3\1\112\1\3\25\0\2\3\16\0\5\3\1\113"+
    "\7\3\1\0\7\3\25\0\2\3\16\0\5\3\1\114"+
    "\7\3\1\115\1\116\6\3\56\0\1\117\1\0\1\120"+
    "\36\0\2\3\16\0\11\3\1\121\1\3\1\122\1\3"+
    "\1\0\7\3\25\0\2\3\16\0\5\3\1\123\1\3"+
    "\1\124\5\3\1\0\7\3\72\0\1\125\77\0\1\126"+
    "\71\0\1\127\71\0\1\130\71\0\1\131\1\132\74\0"+
    "\1\133\13\0\1\134\67\0\4\61\1\62\71\61\1\62"+
    "\40\61\1\135\30\61\1\62\34\61\1\136\34\61\1\62"+
    "\34\61\1\137\30\61\5\67\1\0\1\140\1\141\62\67"+
    "\12\142\1\143\57\142\14\72\1\62\55\72\16\75\1\60"+
    "\53\75\23\0\1\144\10\0\1\145\36\0\2\3\16\0"+
    "\2\3\1\146\10\3\1\147\1\3\1\0\7\3\25\0"+
    "\2\3\15\0\1\150\1\151\5\3\1\152\6\3\1\0"+
    "\7\3\25\0\2\3\15\0\1\153\1\154\1\3\1\155"+
    "\12\3\1\0\7\3\25\0\2\3\15\0\1\156\1\157"+
    "\14\3\1\0\7\3\25\0\2\3\16\0\3\3\1\160"+
    "\11\3\1\0\7\3\47\0\1\161\47\0\2\3\16\0"+
    "\2\3\1\162\12\3\1\0\7\3\25\0\2\3\16\0"+
    "\10\3\1\163\1\3\1\164\2\3\1\0\7\3\25\0"+
    "\2\3\16\0\15\3\1\0\3\3\1\165\3\3\25\0"+
    "\2\3\16\0\1\3\1\166\13\3\1\0\7\3\25\0"+
    "\2\3\16\0\4\3\1\167\10\3\1\0\7\3\25\0"+
    "\2\3\16\0\6\3\1\170\6\3\1\0\7\3\25\0"+
    "\2\3\16\0\14\3\1\171\1\0\7\3\57\0\1\172"+
    "\37\0\2\3\16\0\12\3\1\173\2\3\1\0\7\3"+
    "\64\0\1\174\32\0\2\3\16\0\15\3\1\0\1\3"+
    "\1\175\5\3\25\0\2\3\16\0\7\3\1\176\5\3"+
    "\1\0\7\3\25\0\2\3\16\0\15\3\1\0\2\3"+
    "\1\177\4\3\24\0\4\61\1\62\23\61\1\200\45\61"+
    "\1\62\17\61\1\201\51\61\1\62\24\61\1\202\40\61"+
    "\7\0\1\203\62\0\12\142\1\204\57\142\11\0\1\141"+
    "\1\143\102\0\1\205\47\0\2\3\16\0\2\3\1\206"+
    "\12\3\1\0\7\3\51\0\1\207\45\0\2\3\16\0"+
    "\4\3\1\210\10\3\1\0\7\3\25\0\2\3\16\0"+
    "\2\3\1\211\12\3\1\0\7\3\47\0\1\212\47\0"+
    "\2\3\16\0\2\3\1\213\12\3\1\0\7\3\25\0"+
    "\2\3\16\0\2\3\1\214\12\3\1\0\7\3\51\0"+
    "\1\215\45\0\2\3\16\0\4\3\1\216\10\3\1\0"+
    "\7\3\25\0\2\3\16\0\15\3\1\0\4\3\1\217"+
    "\2\3\25\0\2\3\16\0\4\3\1\220\10\3\1\0"+
    "\7\3\25\0\2\3\16\0\4\3\1\221\10\3\1\0"+
    "\7\3\25\0\2\3\16\0\12\3\1\222\2\3\1\0"+
    "\7\3\25\0\2\3\15\0\1\223\1\224\14\3\1\0"+
    "\7\3\54\0\1\225\42\0\2\3\16\0\7\3\1\226"+
    "\5\3\1\0\7\3\25\0\2\3\16\0\3\3\1\227"+
    "\11\3\1\0\7\3\24\0\4\61\1\62\24\61\1\230"+
    "\44\61\1\231\71\61\1\232\65\61\10\0\1\141\61\0"+
    "\11\142\1\141\1\204\57\142\1\0\2\3\16\0\1\3"+
    "\1\233\13\3\1\0\7\3\25\0\2\3\16\0\10\3"+
    "\1\234\4\3\1\0\7\3\25\0\2\3\16\0\7\3"+
    "\1\235\5\3\1\0\7\3\51\0\1\236\45\0\2\3"+
    "\16\0\4\3\1\237\10\3\1\0\7\3\25\0\2\3"+
    "\16\0\1\3\1\240\13\3\1\0\7\3\24\0\4\61"+
    "\1\241\65\61\1\0\2\3\16\0\6\3\1\242\6\3"+
    "\1\0\7\3\25\0\2\3\16\0\15\3\1\0\5\3"+
    "\1\243\1\3\25\0\2\3\15\0\1\244\1\245\14\3"+
    "\1\0\7\3\25\0\2\3\16\0\2\3\1\246\12\3"+
    "\1\0\7\3\25\0\2\3\16\0\5\3\1\247\7\3"+
    "\1\0\7\3\25\0\2\3\16\0\10\3\1\250\4\3"+
    "\1\0\7\3\25\0\2\3\16\0\7\3\1\251\5\3"+
    "\1\0\7\3\24\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5916];
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
    "\1\0\1\11\5\1\2\11\1\1\1\11\21\1\3\11"+
    "\4\1\2\11\1\1\7\11\2\0\1\11\1\0\1\11"+
    "\3\0\1\11\1\1\3\0\1\1\2\0\1\1\1\0"+
    "\5\1\1\0\7\1\1\0\1\1\1\11\1\0\4\1"+
    "\7\11\1\1\3\0\1\1\1\11\3\0\1\11\2\1"+
    "\1\0\2\1\1\0\2\1\1\0\2\1\1\11\10\1"+
    "\1\11\1\1\1\0\3\1\5\0\1\11\1\1\1\11"+
    "\2\1\1\11\2\1\1\11\5\1\1\0\1\1\1\11"+
    "\2\1\1\0\2\11\3\1\1\11\2\1\1\11\2\1"+
    "\1\11\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[169];
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
  public LexicoHK(java.io.Reader in) {
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
          case 61: break;
          case 2: 
            { lexeme=yytext(); return new Symbol(sym.id,yycolumn, yyline, new String(yytext()));
            }
          case 62: break;
          case 3: 
            { lexeme=yytext(); return new Symbol(sym.numero,yycolumn, yyline,new String(yytext()));
            }
          case 63: break;
          case 4: 
            { /*Ignore*/
            }
          case 64: break;
          case 5: 
            { return new Symbol(sym.salto  ,yycolumn, yyline,new String(yytext()));
            }
          case 65: break;
          case 6: 
            { return new Symbol(sym.div  ,yycolumn, yyline,new String(yytext()));
            }
          case 66: break;
          case 7: 
            { return new Symbol(sym.por  ,yycolumn, yyline,new String(yytext()));
            }
          case 67: break;
          case 8: 
            { return new Symbol(sym.mas  ,yycolumn, yyline,new String(yytext()));
            }
          case 68: break;
          case 9: 
            { return new Symbol(sym.menos  ,yycolumn, yyline,new String(yytext()));
            }
          case 69: break;
          case 10: 
            { return new Symbol(sym.dosPuntos  ,yycolumn, yyline,new String(yytext()));
            }
          case 70: break;
          case 11: 
            { return new Symbol(sym.dollar  ,yycolumn, yyline,new String(yytext()));
            }
          case 71: break;
          case 12: 
            { return new Symbol(sym.mayor, yycolumn, yyline,new String(yytext()));
            }
          case 72: break;
          case 13: 
            { return new Symbol(sym.menor, yycolumn, yyline,new String(yytext()));
            }
          case 73: break;
          case 14: 
            { return new Symbol(sym.igual, yycolumn, yyline,new String(yytext()));
            }
          case 74: break;
          case 15: 
            { return new Symbol(sym.not, yycolumn, yyline,new String(yytext()));
            }
          case 75: break;
          case 16: 
            { return new Symbol(sym.parentesisA, yycolumn, yyline,new String(yytext()));
            }
          case 76: break;
          case 17: 
            { return new Symbol(sym.parentesisC, yycolumn, yyline,new String(yytext()));
            }
          case 77: break;
          case 18: 
            { return new Symbol(sym.coma ,yycolumn, yyline,new String(yytext()));
            }
          case 78: break;
          case 19: 
            { return new Symbol(sym.llaveA  ,yycolumn, yyline,new String(yytext()));
            }
          case 79: break;
          case 20: 
            { return new Symbol(sym.llaveC  ,yycolumn, yyline,new String(yytext()));
            }
          case 80: break;
          case 21: 
            { return new Symbol(sym.corcheteA, yycolumn, yyline,new String(yytext()));
            }
          case 81: break;
          case 22: 
            { return new Symbol(sym.corcheteC, yycolumn, yyline,new String(yytext()));
            }
          case 82: break;
          case 23: 
            { return new Symbol(sym.porcentaje  ,yycolumn, yyline,new String(yytext()));
            }
          case 83: break;
          case 24: 
            { return new Symbol(sym.puntoComa  ,yycolumn, yyline,new String(yytext()));
            }
          case 84: break;
          case 25: 
            { lexeme=yytext(); return new Symbol(sym.cadena ,yycolumn, yyline,new String(yytext()));
            }
          case 85: break;
          case 26: 
            { lexeme=yytext(); return new Symbol(sym.caracter ,yycolumn, yyline,new String(yytext()));
            }
          case 86: break;
          case 27: 
            { return new Symbol(sym.or, yycolumn, yyline,new String(yytext()));
            }
          case 87: break;
          case 28: 
            { 
            }
          case 88: break;
          case 29: 
            { return new Symbol(sym.si, yycolumn, yyline,new String(yytext()));
            }
          case 89: break;
          case 30: 
            { return new Symbol(sym.concatenar  ,yycolumn, yyline,new String(yytext()));
            }
          case 90: break;
          case 31: 
            { return new Symbol(sym.menorIgual, yycolumn, yyline,new String(yytext()));
            }
          case 91: break;
          case 32: 
            { return new Symbol(sym.mayorIgual, yycolumn, yyline,new String(yytext()));
            }
          case 92: break;
          case 33: 
            { return new Symbol(sym.igualDoble, yycolumn, yyline,new String(yytext()));
            }
          case 93: break;
          case 34: 
            { return new Symbol(sym.diferente, yycolumn, yyline,new String(yytext()));
            }
          case 94: break;
          case 35: 
            { return new Symbol(sym.posicion  ,yycolumn, yyline,new String(yytext()));
            }
          case 95: break;
          case 36: 
            { return new Symbol(sym.and, yycolumn, yyline,new String(yytext()));
            }
          case 96: break;
          case 37: 
            { lexeme=yytext(); return new Symbol(sym.decimal, yycolumn, yyline,new String(yytext()));
            }
          case 97: break;
          case 38: 
            { return new Symbol(sym.sum, yycolumn, yyline,new String(yytext()));
            }
          case 98: break;
          case 39: 
            { return new Symbol(sym.end, yycolumn, yyline,new String(yytext()));
            }
          case 99: break;
          case 40: 
            { return new Symbol(sym.asc, yycolumn, yyline,new String(yytext()));
            }
          case 100: break;
          case 41: 
            { return new Symbol(sym.let,yycolumn, yyline, new String(yytext()));
            }
          case 101: break;
          case 42: 
            { return new Symbol(sym.max  ,yycolumn, yyline,new String(yytext()));
            }
          case 102: break;
          case 43: 
            { return new Symbol(sym.min  ,yycolumn, yyline,new String(yytext()));
            }
          case 103: break;
          case 44: 
            { return new Symbol(sym.par, yycolumn, yyline,new String(yytext()));
            }
          case 104: break;
          case 45: 
            { return new Symbol(sym.succ, yycolumn, yyline, new String(yytext()));
            }
          case 105: break;
          case 46: 
            { return new Symbol(sym.caso, yycolumn, yyline,new String(yytext()));
            }
          case 106: break;
          case 47: 
            { return new Symbol(sym.desc, yycolumn, yyline,new String(yytext()));
            }
          case 107: break;
          case 48: 
            { return new Symbol(sym.decc,yycolumn, yyline, new String(yytext()));
            }
          case 108: break;
          case 49: 
            { return new Symbol(sym.sino, yycolumn, yyline,new String(yytext()));
            }
          case 109: break;
          case 50: 
            { return new Symbol(sym.verdadero, yycolumn, yyline,new String(yytext()));
            }
          case 110: break;
          case 51: 
            { return new Symbol(sym.entonces, yycolumn, yyline,new String(yytext()));
            }
          case 111: break;
          case 52: 
            { return new Symbol(sym.impr, yycolumn, yyline,new String(yytext()));
            }
          case 112: break;
          case 53: 
            { return new Symbol(sym.mod  ,yycolumn, yyline,new String(yytext()));
            }
          case 113: break;
          case 54: 
            { return new Symbol(sym.pot  ,yycolumn, yyline,new String(yytext()));
            }
          case 114: break;
          case 55: 
            { return new Symbol(sym.falso, yycolumn, yyline,new String(yytext()));
            }
          case 115: break;
          case 56: 
            { return new Symbol(sym.sqrt  ,yycolumn, yyline,new String(yytext()));
            }
          case 116: break;
          case 57: 
            { return new Symbol(sym.length, yycolumn, yyline,new String(yytext()));
            }
          case 117: break;
          case 58: 
            { return new Symbol(sym.revers, yycolumn, yyline,new String(yytext()));
            }
          case 118: break;
          case 59: 
            { return new Symbol(sym.product, yycolumn, yyline,new String(yytext()));
            }
          case 119: break;
          case 60: 
            { return new Symbol(sym.calcular  ,yycolumn, yyline,new String(yytext()));
            }
          case 120: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
