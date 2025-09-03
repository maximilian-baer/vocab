import './App.css'
import {useState, useEffect} from 'react'


export default function App() {
    const [text, setText] = useState('');
    const [resMsg, setResMsg] = useState(null);

    const handleSend = async () => {
        if(!text.trim()) return;
        try {
            const res = await fetch('http://localhost:8080', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({text})
            });
            if(!res.ok) throw new Error(`HTTP ${res.status}: ${res.statusText}`);
            const data = await res.json();
            setResMsg(JSON.stringify(data));
        } catch (error) {
            setResMsg(`${error.message}`);
        }

    }
    return (
        <div>
            <h1>hello</h1>
            <input value={text} onChange={e => setText(e.target.value)} placeholder="Nachricht"/>
            <button onClick={handleSend}>Send</button>
            {resMsg && <pre>{resMsg}</pre>}
        </div>
    )
}
