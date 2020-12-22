<?php

// 签名生成(sha256)
function newSignature($key, $data) {
    return hash_hmac('sha256', $data, $key);
}

$sign = newSignature("key", "123");
echo $sign;
// a7f7739b1dc5b4e922b1226c9fcbdc83498dee375382caee08fd52a13eb7cfe2
