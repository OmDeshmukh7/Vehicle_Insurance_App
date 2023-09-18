export class Claim{
    constructor(public claimId?: number,
        public claimDate?: string,
        public claimAmount?: number,
        public claimDescription?: string,
        public claimStatus: string = 'pending',
        public insuranceId?: number,
        public endUserId?: number){}
}