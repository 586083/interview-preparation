# Java I/O Hierarchy

```text
                        Java I/O
                           |
        ------------------------------------
        |                                  |
   Byte Streams                    Character Streams
(InputStream/OutputStream)         (Reader/Writer)
        |                                  |
  FileInputStream                  FileReader
  FileOutputStream                 FileWriter
        |                                  |
 BufferedInputStream             BufferedReader
 BufferedOutputStream            BufferedWriter
```
# Summary

| Class              | Reads/Writes | Data Type  | Buffered | Typical Use                       |
| ------------------ | ------------ | ---------- | -------- | --------------------------------- |
| `FileInputStream`  | Read         | Bytes      | ❌        | Images, PDFs, ZIPs, videos        |
| `FileOutputStream` | Write        | Bytes      | ❌        | Binary file output                |
| `FileReader`       | Read         | Characters | ❌        | Small text files                  |
| `FileWriter`       | Write        | Characters | ❌        | Small text files                  |
| `BufferedReader`   | Read         | Characters | ✅        | Large text files, logs, CSV, JSON |
| `BufferedWriter`   | Write        | Characters | ✅        | Efficient text output             |

## 1.FileInputStream

Reads raw bytes from a file.

```text

File
 ↓
10101010
11110000
00101101
 ↓
byte[]

No character conversion happens.
```
### Pros
1. Reads any file.
2. No encoding issues.
3. Suitable for binary data.

### Cons
1. Slow if reading one byte at a time.
2. Not suitable for text.

## 2.FileReader

Reads raw bytes from a file.

```text

File

01001000
01100101
01101100

↓

Character Decoder

↓

H
e
l
```
### Pros
1. Simple for text.

### Cons
1. Reads one character at a time.
2. Very slow for large files.


## 3.BufferedReader

One of the most commonly used classes. Instead of reading one character at a time.it reads a large block into memory.

```text

File

↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

+----------------------+
| Internal Buffer 8 KB |
+----------------------+

H e l l o
```

Without buffering
Every read() goes to disk. Thousands of system calls.
```text
File
 ↓
OS
 ↓
Disk
 ↓
Java
```
Far fewer disk accesses.
```text
Read 8 KB once

↓

Serve from RAM
```

### Pros
1. Very fast.

### Cons
1. Text only.
2. Cannot read binary.