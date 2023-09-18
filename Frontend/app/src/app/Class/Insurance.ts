export class Insurance{

    constructor(
       public insuranceId?:number ,
       public insuranceAmount?: DoubleRange,
       public insuranceNumber?: string,
       public insuranceDescription?: string,
       public insuranceType?: string,
       public endUserId?: number,
       public status?: string
    ){}
}