import * as os from 'os';

const init = os.networkInterfaces()['en0'][0].mac;
const mac = init.toUpperCase().split(':').join('-');
console.log(mac);