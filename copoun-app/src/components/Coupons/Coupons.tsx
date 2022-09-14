import { useEffect, useState } from "react";

const Coupons = () => {

    const [coupons, setCoupons] = useState([] as any[]);

    const fillCoupons = async () => {
        const response = await fetch('http://localhost:8080/company/coupons', {
            headers: {
                Authorization: '1c09c1c0-b5df-4ec6-9b6b-ec9ba3014322'
            }
        })

        const coupons = await response.json()

        setCoupons(coupons);
    }

    useEffect(() => {
        fillCoupons()
    }, [])



    return (
        <div className="">
            {coupons.map((coupon) => (
                <div>{coupon.id}</div>
            ))}
        </div>
    );
}

export default Coupons;