package main

import (
	"crypto/hmac"
	"crypto/sha256"
	"encoding/hex"
	"fmt"
	"github.com/pkg/errors"
)

// 签名生成(sha256)
func newSignature(key, data []byte) string {
	h := hmac.New(sha256.New, key)
	if _, e := h.Write(data); e != nil {
		e = errors.Wrap(e, "call: h.Write")
		panic(e)
	}
	return hex.EncodeToString(h.Sum(nil))
}

func main() {
	sign := newSignature([]byte("key"), []byte("123"))
	fmt.Println(sign)
	// a7f7739b1dc5b4e922b1226c9fcbdc83498dee375382caee08fd52a13eb7cfe2
}
