"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const os = require("os");
const init = os.networkInterfaces()['en0'][0].mac;
const mac = init.toUpperCase().split(':').join('-');
console.log(mac);
//# sourceMappingURL=hostMacAddress.js.map