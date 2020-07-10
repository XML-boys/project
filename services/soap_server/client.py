from zeep import Client

client = Client("http://localhost:8080/ClientProbeService/soap/description")
print("Sending request")
result = client.service.add(1,2)

print(result)
assert result == 3

print(client.service.group())
