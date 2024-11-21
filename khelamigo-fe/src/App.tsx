import './App.css'

import Stack from '@mui/material/Stack';
import Navbar from './components/Navbar';
import Main from './components/Main';

import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme({
  components: {
    MuiButtonBase: {
      defaultProps: {
        
      },
    },
  },
});


function App() {
  
  return (
    <ThemeProvider theme={theme}>
      <Stack spacing={0} sx={{width:'100%'}}>
        <Navbar/>
        <Main/>
      </Stack>
    </ThemeProvider>
  )
}

export default App
