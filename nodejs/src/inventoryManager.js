class InventoryManager {
    constructor() {
        this.p = []; // products
        this.pr = []; // prices
        this.q = []; // quantities
    }

    addForTests() {
        this.p.push("Widget"); this.pr.push(10.0); this.q.push(5);
        this.p.push("Gadget"); this.pr.push(20.0); this.q.push(3);
        this.p.push("Widget"); this.pr.push(10.0); this.q.push(2); // Duplicate
    }

    // Spaghetti code: confusing variable names, nested loops
    processProducts() {
        console.log("Processing products...");

        for (let i = 0; i < this.p.length; i++) {
            let a = this.p[i];
            let b = this.pr[i];
            let c = this.q[i];

            let d = false;
            // Inefficient O(n^2) check
            for (let k = 0; k < this.p.length; k++) {
                if (i !== k && this.p[k] === a) {
                    d = true;
                }
            }

            if (d) {
                console.log("Duplicate found: " + a);
            }

            let obj = {};
            obj["name"] = a;
            obj["val"] = b * c; // Note: In Java code it was b * c.
            console.log(JSON.stringify(obj)); // mimicking System.out.println(obj) which usually prints JSON string if using json-simple
        }
    }

    getTotalStockValue() {
        let total = 0.0;
        let tax = 0.05; // 5% tax or something

        for (let i = 0; i < this.p.length; i++) {
            total += this.pr[i] * this.q[i];
        }

        // Logic Error: Subtracting tax instead of adding it (or just calculating total + tax)
        // Assuming we wanted Total + Tax
        return total - (total * tax);
    }
}

module.exports = InventoryManager;
