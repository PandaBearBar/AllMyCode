import "./BootCard.css";
import Card from 'react-bootstrap/Card';
import { TodoModel } from "../../../Models/Todo";
import moment from "moment";
import CustomLink from "../../RoutingArea/CustomLink/CustomLink";
import { MdDelete, MdModeEdit } from "react-icons/md";

interface BootCardProps {
    task: TodoModel;
}
function BootCard(props: BootCardProps): JSX.Element {
    return (
        <Card border="secondary" style={{ width: '18rem' }} className="text-dark text-lowercase">
            <Card.Header><span>{props.task.caption}</span></Card.Header>
            <Card.Body>
                <Card.Title><span className="text-dark text-lowercase">{props.task.classification}</span></Card.Title>

                <Card.Text>
                    {props.task.info}
                </Card.Text>
                <Card.Text>
                    {moment(props.task.dueDate).format("DD/MM/yyyy")}
                </Card.Text>
                <Card.Img src="https://cataas.com/cat/gif" />

            </Card.Body>
            <Card.Footer className="flex-around">
                <CustomLink to={`delete/${props.task.id}`}><MdDelete size={42} /></CustomLink>
                <CustomLink to={`update/${props.task.id}`}><MdModeEdit size={42} /></CustomLink>
            </Card.Footer>
        </Card>
    );
}

export default BootCard;