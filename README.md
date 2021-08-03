## oauth2-password-grant
There's no ResourceServer, this will be added in another repository. Just plain authorization-server

For testing purposes here's a link
http://localhost:8080/oauth/token?grant_type=password&username=test&scope=read&password=test
Use the authorization server credentials in the basic auth

Then you can proceed to test the token
http://localhost:8080/oauth/check_token?token=b99ed0d5-a8ee-477f-8bc4-7751f1dcdb9e
Use the resource server credentials in the basic auth


# Optional
## Generate private and public key with Git Bash

### Generating Private Key
keytool -genkeypair -alias ssia -keyalg RSA -keypass ssia123 -keystore ssia.jks -storepass ssia123

### Obtaining Public Key
keytool -list -rfc --keystore ssia.jks | openssl x509 -inform pem -pubkey
