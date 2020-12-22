const crypto = require("crypto")

// 签名生成(sha256)
function newSignature(key, data) {
    let hmac = crypto.createHmac("sha256", key)
    let sign
    hmac.on("readable", () => {
        let r = hmac.read()
        if (r) {
            sign = r.toString("hex")
        }
    })
    hmac.write(data)
    hmac.end()
    return sign
}

let sign = newSignature("key", "123")
console.log(sign)
// a7f7739b1dc5b4e922b1226c9fcbdc83498dee375382caee08fd52a13eb7cfe2
