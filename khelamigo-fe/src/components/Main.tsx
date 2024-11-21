import Box from "@mui/material/Box/Box";
import Grid from '@mui/material/Grid2';
import CreatePostCard from "./CreatePostCard";
import MenuItems from "./MenuItems";



export default function Main(){

    return (
        <Box sx={{background: '#f2f4f7'}}>
            <Grid container spacing={0}>
                <Grid size={3}>
                    <MenuItems/>
                </Grid>
                <Grid size={6} sx={{paddingLeft: '5%', paddingRight: '5%', paddingTop: '20px', paddingBottom: '20px'}}>
                    <CreatePostCard/>
                </Grid>
                <Grid size={3}>
                    3
                </Grid>
            </Grid>
        </Box>
    )
}