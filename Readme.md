# Java Multicodec

## About
The specifications for Decentralised Identifiers (DIDs) make use of multicodec specification.
The multicodec is an agreed way for encodiong bytes with a prefix that specifies the type of encoding. The format is therefore a portable and self describing way of expressing an encoding of bytes that does not assume a specific context. 

For example the multicodec specification is used in the DID Method 'key' specification
See:
 - https://w3c-ccg.github.io/did-method-key
 - https://github.com/multiformats/multicodec/blob/master/README.md

The code of a multicodec is usually encoded as unsigned varint as defined by [multiformats/unsigned-varint](https://github.com/multiformats/unsigned-varint). It is then used as a prefix to identify the data that follows.
This represents some additional non trivial binary operations. 

It is noted that the [multiformats/unsigned-varint](https://github.com/multiformats/unsigned-varint) lists technology implementations, however a java implementation is not available.
This library addresses that gap to provide an implementation of the multicodec specification in java.
