
# Endianness

### Big Endian
Writing most significant bit at the smallest address

### Small Endian
Writing least significant bit at the smallest address



### Whenever any computer is starting to write data to disk/nw
1. Attaches a header specifying the endianness
2. Both parties agrees to common byte order
    * Initial message exchange
    * Specific encoders or decoders
    * Formal specification
3. Byte order masking
    * Attach 0xFEFF
    * It sent with every number
    * Receving machine reads 0xFFFE it needs to translate it.


## Result

> Number 270544960 <br>
> Byte array as LE [16, 32, 48, 64] <br>
> LE interpretation: 0x40302010, int value **1076895760** <br>
> BE interpretation: 0x10203040, int value **270544960**