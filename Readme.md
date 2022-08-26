# Java Multicodec

## About Multiformats
Multicodec is part of the Multiformats collection of protocols. 
Multiformats is a collection of protocols which aim to future-proof systems, today. They do this mainly by allowing 
data to be self-describable.
See:
- https://github.com/multiformats/multiformats

## About Multicodec
The Multicodec is an agreed way for encoding bytes with a prefix that specifies the type of encoding.
The format is therefore a portable and self describing way of expressing an encoding of bytes that does not assume
a specific context.
See:
- https://github.com/multiformats/multicodec

### Examples
For example, the multicodec specification is used in the specifications for Decentralised Identifiers (DIDs) in
regard to the DID Method 'key' specification. 
Therefore, any work on `did:key` implementations needs to also solve for the use of multicodecs.
See:
 - https://w3c-ccg.github.io/did-method-key

### Why A Java Implementation?
It is noted that the [https://github.com/multiformats/multiformats](https://github.com/multiformats/multiformats) 
lists technology implementations, however a java implementation is not available.
This library addresses that gap to provide an implementation of the multicodec specification in java.

### Dependencies
The code of a multicodec is encoded as unsigned varint as defined by
[multiformats/unsigned-varint](https://github.com/multiformats/unsigned-varint).
It is then used as a prefix to identify the data that follows. This represents some additional binary operations.

This project also solves for a java implementation of unsigned varints so may also be of use for implementors.