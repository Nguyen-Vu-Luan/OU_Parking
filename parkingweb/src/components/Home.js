import { Button, Card, Col, Row, Spinner } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { useEffect, useState } from "react";

const Home = () => {
    const [ParkingLots, setLots] = useState([]);
    const [page, setPage] = useState(1);
    const [loading, setLoading] = useState(false);
    // const [pl] = useSearchParams(); 

    const loadLots = async () => {
        try {
            setLoading(true);

            let url = `${endpoints['parkinglots']}?page=${page}`
            // let plID = pl.get("parkinglotsId")
            // if(plID) {
            //     url = `${url}&parkinglotsId=${plID}`
            // }
            // let res = await Apis.get(url);
            // setLots(res.data);
        }
        catch {
        }
        finally {
            setLoading(false)
        }
    }

    useEffect(() => {
        loadLots();
    }, [])

    return (
        <>
            <Row>
                {ParkingLots.map(pl => <Col className="p-5" key={pl.id} md={3} xs={6}>
                    <Card style={{ width: '18rem' }}>
                        {/* <Card.Img variant="top" src={pl.image} /> */}
                        <Card.Body>
                            <Card.Title>{pl.name}</Card.Title>
                            <Card.Text>
                                {pl.pricePerHour} VND
                            </Card.Text>
                            <Button variant="primary">Xem chi tiết</Button>
                        </Card.Body>
                    </Card>
                </Col>)}
            </Row>
            {loading && <Spinner animation="grow" variant="primary" />}
        </>
    );
}

export default Home;