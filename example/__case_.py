import hmac

# 签名生成(sha256)
def newSignature(key, data):
    h = hmac.new(key.encode("utf-8"), data.encode("utf-8"), "sha256")
    return h.hexdigest()

if __name__ == "__main__":
    sign = newSignature("key", "123")
    print(sign)
    # a7f7739b1dc5b4e922b1226c9fcbdc83498dee375382caee08fd52a13eb7cfe2
