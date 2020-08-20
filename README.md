# pat4-route

## Description
This project was made to serialize/deserialize according to Pat4 route file format.

## File Format
Below is a description of the file format (by trial and error).
LE = Little-Endian

### [Route]

| Name | Type | Description |
| --- | --- | --- |
| start | LE Int | value of 4 |
| cityCount | LE Int | city count |
| nameLength |  LE Int | length of route file name including NUL delimiter |
| travelTime | LE Int | travel time in days |
| name | LE Chars | route name (not the route's save name), null terminated |
| cities | City[n] |  n blocks of city data, see [City] |
| close | Byte[4] | 0xfeafdeba, closing symbol. |
| saveName | LE Chars | route save name (not the route's name), null terminated |

### [City]

| Name | Type | Description |
| --- | --- | --- |
| cityId | Byte | The city's id |
| repair | Byte | Should repair? 1 if ship should be repaired |
| skip | Byte | hould skip the town? 1 if ship should skip the town |
| orders | Order[20] | 20 orders for 20 goods. See [Order] |

### [Order]

| Name | Type | Description |
| --- | --- | --- |
| goodId | Byte | The good's id |
| tradeType | Byte | Trade type. 0 - NO_TRADE, 1 - AUTO_TRADE, 2 - MANUAL_TRADE. |
| loadPriceFactor | LE Float | Load price factor. It is the price factor, not the price.  Aka for wood buying at 26.4, base price is 33, so this becomes 0.8. Negative value means that it should load from your warehouse. |
| unloadPriceFactor | LE Float | Unload price factor. It is the price factor, not the price. Aka for wood selling at 66, base price is 33, so this becomes 2. Negative value means that it should load from your warehouse. |
| loadQty | LE Int | load quantity |
| unloadQty | LE Int | unload quantity |
