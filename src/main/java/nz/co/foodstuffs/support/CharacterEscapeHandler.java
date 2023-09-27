package nz.co.foodstuffs.support;

import java.io.IOException;
import java.io.Writer;

public interface CharacterEscapeHandler {
    /**
     * @param ch The array of characters.
     * @param start The starting position.
     * @param length The number of characters to use.
     * @param isAttVal true if this is an attribute value literal.
     */
    void escape( char[] ch, int start, int length,
                 boolean isAttVal, Writer out ) throws IOException;
}