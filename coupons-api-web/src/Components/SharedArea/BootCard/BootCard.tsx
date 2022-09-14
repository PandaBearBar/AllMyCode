import "./BootCard.css";
import Card from 'react-bootstrap/Card';
import moment from "moment";
import CustomLink from "../../RoutingArea/CustomLink/CustomLink";
import { MdDelete, MdModeEdit } from "react-icons/md";
import { CouponModel } from "../../../Models/CouponModel";

interface BootCardProps {
    coupon: CouponModel;
}
function BootCard(props: BootCardProps): JSX.Element {
    return (
        <Card border="secondary" style={{ width: '18rem' }} className="text-dark text-lowercase">
            <Card.Header><span>{props.coupon.title}</span></Card.Header>
            <Card.Body>
                <Card.Title><span className="text-dark text-lowercase">{props.coupon.category}</span></Card.Title>
                <Card.Text>
                    {props.coupon.description}
                </Card.Text>
                <Card.Text>
                    {moment(props.coupon.startDate).format("DD/MM/yyyy")}
                </Card.Text>
                <Card.Text>
                    {moment(props.coupon.endDate).format("DD/MM/yyyy")}
                </Card.Text>
                <Card.Text>
                    {props.coupon.amount}
                </Card.Text>
                <Card.Text>
                    {props.coupon.price}
                </Card.Text>
                <Card.Img src={props.coupon.image} height="100" width={100}/>
            </Card.Body>
            <Card.Footer className="flex-around">
                <CustomLink to={`delete/${props.coupon.id}`}><MdDelete size={42} color="red"/></CustomLink>
                <CustomLink to={`update/${props.coupon.id}`}><MdModeEdit size={42} color="blue"/></CustomLink>
            </Card.Footer>
        </Card>
    );
}

export default BootCard;